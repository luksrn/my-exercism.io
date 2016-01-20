def to_rna(dna):
    nucleotideMapping = { 'G':'C', 'C':'G', 'T':'A',  'A':'U'}
    transcribedRna = []
    for nucleotide in dna:
        transcribedRna.append(nucleotideMapping[nucleotide])
    return ''.join(transcribedRna)
