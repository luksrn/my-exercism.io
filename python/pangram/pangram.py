import string

def is_pangram(str):
    if len(str) == 0:
        return False

    ocorrences = []
    for i in range(len(str)):
        if str[i].isalpha():
            ocorrences.append(str[i].lower())
    return len(set(ocorrences)) == 26
