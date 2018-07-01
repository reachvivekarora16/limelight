1. Program start from MainApp.java. It takes  2 input i.e. file path. One is transform.txt file contains series of transformation. Another one is text.txt file contains text to be encoded.
2. MainApp calls BuildEncoder.java which build list of transformation objects from EncoderFactory.java
3. From the BuildEncoder object instance we call encode method. This method performs following operations
   i  Read input text.txt file line by line
   ii For each line input to encode method, convert string to lowercase 
   iii Create transformMap from original keyboard to final transformed keyboard via getTransformedKeyboard() function in BuildEncoder.java
   iv. Map each character from the input line to transformed character. If character is not present in Map then return original character
   v. Return transformed String line

4. Add returned transformed string to StringBuilder and repeat for other lines
5. Convert final StringBuilder to String and print the string 
6. We can write to file of printing to console
7. For large file we are reading line by line and performing series of transformation of keyboard and translation of text line by line to transformedKeyboard

  


 