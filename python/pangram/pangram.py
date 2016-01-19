import string

def is_pangram(phrase):
    ocorrences = []
    for letter in phrase.lower():
        if letter.isalpha() and letter not in ocorrences:
            ocorrences.append(letter)
    return len(ocorrences) == len(string.lowercase)
