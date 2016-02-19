### Line Counter Java

Desenvolva um utilitário que conte o número de linhas de código efetivo em um arquivo-fonte em Java. Considere uma linha se ela não contiver apenas caracteres em branco ou texto dentro de comentários. Alguns exemplos:

```
- // This file contains 3 lines of code
1 public interface Dave {
- /**
- * count the number of lines in a file
- */
2 int countLines(File inFile); // not the real signature!
3 }
```

```
- /*****
- * This is a test program with 5 lines of code
- * \/* no nesting allowed!
- //*****//***/// Slightly pathological comment ending...
-
1 public class Hello {
2 public static final void main(String [] args) { // gotta love Java
- // Say hello
3 System./*wait*/out./*for*/println/*it*/("Hello/*");
4 }
-
5 }

```

Lembre-se que comentários em Java podem ser ou "//" até o final de uma linha, ou "/*" até encontrar "*/". Podem existir múltiplos "/*...*/" comentário em uma linha. Caracteres em branco incluem tabulações, espações e quebras de linha. Comentários dentro de string Java devem ser ignorados.
