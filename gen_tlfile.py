import json

if __name__ == '__main__':
    df_string = ""
    with open('schema.json') as f:
        data: dict = json.load(f)

    for key, value in data.items():
        for val in value:
            if key == "constructors":
                id, predicate, params, type = val.values()
                name = predicate.split(".")[-1]
                name = name[0].upper() + name[1:]
                print(name)
                df_string += "objects.put({0}.ID, {0}.class);\n".format(name)

    with open('twrite.txt', 'w') as f:
        f.write(df_string)
