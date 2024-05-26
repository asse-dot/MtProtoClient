import json
import os

EXTENSION = ".java"
PACKAGE = "src/main/java/telegram/raw/"

blacklist = ["default", "public", "private", "int", "short", "long", "byte", "bytes", "protected", "static", "void", "final"]

mapper_read = {
    'int' : 'IntPrimitive.read(bytes).getValue()',
    'long' : 'LongPrimitive.read(bytes).getValue()',
    'byte[]' : 'BytesPrimitive.read(bytes).getValue()',
    'TlObject' : 'TlObject.read(bytes)',
    'ArrayList<TlObject>' : '((VectorPrimitive)TlObject.read(bytes)).getValue()',
    'String' : 'StringPrimitive.read(bytes).getValue()'
}

mapper_write = {
    'int' : 'new IntPrimitive(this.{}).write()',
    'long' : 'new LongPrimitive(this.{}).write()',
    'byte[]' : 'new BytesPrimitive(this.{}).write()',
    'TlObject': 'this.{}.write()',
    'ArrayList<TlObject>' : 'new VectorPrimitive(this.{}).write()',
    'String' : 'new StringPrimitive(this.{}).write()',
    'int_flag' : 'new IntPrimitive({}).write()'
}


def write_data_writer(params):
    data_writer = ""
    data_writer_con = ""
    data_writer_in = ""
    for param in params:
        name, _type = param.values()
        if name in blacklist:
            name += 'v'
        if '?' in _type: #is flag
            _type = _type.split('?')[1]

        if _type == "#": #flag
            continue

        if _type != "int" and _type != "long":
            if "Vector" in _type:
                _type = "ArrayList<TlObject>"
            elif _type == 'true' or _type == 'false':
                _type = 'boolean'
            elif _type == 'string':
                _type = 'String'
            elif _type == 'bytes':
                _type = 'byte[]'
            else:
                _type = "TlObject"

        data_writer += "public {} {};\n\t".format(_type, name)
        data_writer_con += "{} {}, ".format(_type, name)
        data_writer_in += "this.{0} = {0};\n\t\t".format(name)

    data_writer = data_writer[:-2]
    data_writer_con = data_writer_con[:-2]
    data_writer_in = data_writer_in[:-3]
    return data_writer, data_writer_con, data_writer_in



def write_read_format(params, name_object):

    buff_str = ""
    for param in params:
        name, _type = param.values()
        if name in blacklist:
            name += 'v'
        if "?" not in _type:
            if _type != "int" and _type != "long":
                if "Vector" in _type:
                    _type = "ArrayList<TlObject>"
                elif _type == '#':
                    _type = 'int'
                elif _type == 'true' or _type == 'false':
                    _type = 'boolean'
                elif _type == 'string':
                    _type = 'String'
                elif _type == 'bytes':
                    _type = 'byte[]'
                else:
                    _type = "TlObject"


            buff_str += "{} {} = {};\n\t\t".format(_type, name, mapper_read[_type])
        else:
            flag_name = _type.split('?')[0].split('.')[0]
            flag = _type.split('?')[0].split('.')[1]
            _type = _type.split('?')[1]

            if _type != "int" and _type != "long":
                if "Vector" in _type:
                    _type = "ArrayList<TlObject>"
                elif _type == '#':
                    _type = 'int'
                elif _type == 'true' or _type == 'false':
                    _type = 'boolean'
                elif _type == 'string':
                    _type = 'String'
                elif _type == 'bytes':
                    _type = 'byte[]'
                else:
                    _type = "TlObject"

            if _type == 'boolean':
                buff_str += "{} {} = ({} & (1 << {})) != 0;\n\t\t".format(_type, name, flag_name, flag)
            else:
                buff_str += "{} {} = ({} & (1 << {})) != 0 ?  {} : {};\n\t\t".format(_type, name, flag_name, flag, mapper_read[_type],
                                                                                    'null' if _type != 'int' and _type != 'long' else '0')

    buff_str += "\n\t\treturn new {}({});".format(name_object, ", ".join([param['name'] if param['name'] not in blacklist else param['name'] + 'v' for param in params if param["type"] != '#']))
    return buff_str

def write_write_format(params):
    buff_str = "ByteArrayOutputStream bOut = new ByteArrayOutputStream();\n\t\t\n\t\tbOut.write(new IntPrimitive(ID).write());\n\t\t"

    #init flags
    for param in params:
        name, _type = param.values()
        if name in blacklist:
            name += 'v'
        if _type == '#':
            buff_str += "int {} = 0;\n\t\t".format(name)
        elif '?' in _type:
            flag_name = _type.split('?')[0].split('.')[0]
            flag = _type.split('?')[0].split('.')[1]
            _type = _type.split('?')[1]

            if _type == 'true' or _type == 'false':
                buff_str += "{} |= this.{} ? (1 << {}) : 0;\n\t\t".format(flag_name, name, flag)
            else:
                buff_str += "{} |= (this.{} != {}) ? (1 << {}) : 0;\n\t\t".format(flag_name, name,
                                                                                 'null' if _type != 'int' and _type != 'long' else '0', flag)
    buff_str += '\n\t\t'*2
    for param in params:
        name, _type = param.values()
        if name in blacklist:
            name += 'v'
        is_flag = '?' in _type
        if is_flag:
            _type = _type.split('?')[1]
        if _type != "int" and _type != "long":
            if "Vector" in _type:
                _type = "ArrayList<TlObject>"
            elif _type == 'string':
                _type = 'String'
            elif _type == 'bytes':
                _type = 'byte[]'
            elif _type == 'true' or _type == 'false':
                continue
            elif _type == '#':
                _type = 'int_flag'
            else:
                _type = "TlObject"

        if is_flag:
            buff_str += "if(this.{} != {})\n\t\t\t".format(name, 'null' if _type != 'int' and _type != 'long' else '0')
        buff_str += "bOut.write({});\n\t\t".format(mapper_write[_type].format(name))

    buff_str += "\n\t\treturn bOut.toByteArray();"


    return buff_str
def write_class(df_string, id, object_name, params, value):
    package = ("types" if value == "constructors" else "functions") + "/" + "/".join(object_name.split(".")[:-1])
    #constructors
    if package != "":
        package += "/"
    name = object_name.split(".")[-1]
    name = name[0].upper() + name[1:]

    data_writer, data_writer_con, data_writer_in = write_data_writer(params)
    write_format = write_write_format(params)
    read_format = write_read_format(params, name)

    dict = {"object_name": name, 'id': id, 'data_writer': data_writer,
            'data_writer_con': data_writer_con, 'data_writer_in': data_writer_in, "read_format": read_format,
            "write_format": write_format, "package":".".join(["types" if value == "constructors" else "functions",] + object_name.split(".")[:-1])}

    if not os.path.exists(PACKAGE + package) and package != "":
        os.mkdir(PACKAGE + package)

    try:
        f = open(PACKAGE + package + name + EXTENSION, 'w')
        f.write(df_string.format(**dict))
    except Exception as e:
        print(e)
    finally:
        f.close()


if __name__ == '__main__':
    if not os.path.exists(PACKAGE):
        os.mkdir(PACKAGE)
        os.mkdir(PACKAGE + "functions")
        os.mkdir(PACKAGE + "types")

    with open('schema.json') as f:
        data: dict = json.load(f)

    with open("text_writer.txt", 'r') as f:
        df_string = f.read()
    x = 0
    for key, value in data.items():
        for val in value:
            write_class(df_string, *list(val.values())[:-1], key)
            x += 1
