import string

def is_pangram(str):
    ocorrences = []
    for i in range(len(str)):
        if str[i].isalpha():
            ocorrences.append(str[i].lower())
    return len(set(ocorrences)) == len(string.lowercase)
