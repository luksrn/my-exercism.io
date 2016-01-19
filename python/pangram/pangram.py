import string

def is_pangram(str):
    ocorrences = []
    for letter in list(str.lower()):
        if letter.isalpha() and letter not in ocorrences:
            ocorrences.append(letter)
    return len(ocorrences) == len(string.lowercase)
