Challenge
====================

Danielle, the accountant of your company, needs help with a problem she is facing.  
She needs to deal with a document containing a “Bank Transfer” and a list of 
“Due payments” represented as  decimal numbers with 2 decimal places: 

● An entry in the “Due payments” list represents the amount the 
  company should receive as payment for a given product which has been recently sold 
● The  “Bank Transfer” value represents the amount of a bank transfer which sums up 
  payments of sold items in a specific period of time (as they appear in the company’s 
  account statement). 

Danielle tells you that the “Bank Transfer” amount represents the sum of part 
of the amounts in the “Due payments” list. This is because the amount transferred 
in the company’s account is necessarily the sum of part of the due payments 
of recently sold items. 

The problem is that Danielle does not know to which due payments the bank transfer 
corresponds.  Can you build a small application/tool for Danielle so she could 
use it to speed up her day to day work.  

Example   
Bank Transfer  Due payments 
74.06
22.75   
59.33  
34.22 
27.21 
17.09 
100.99 

In the example above, the solution Danielle found is: 
●  74.06 corresponds to 22.75 + 34.22 + 17.09 Remarks 
● If several solutions exist, only one solution is needed.
  Any correct solution will be accepted.  
● The input of the program is a text file containing one number per line.
   First number represents the bank transfer. The other numbers represent 
   the due payments. Each number has exactly 2 decimals.  
   
For the above example, the input file would contain:  
74.06 
22.75  
59.33  
34.22 
27.21 
17.09 
100.99 

● The output file, named “output.txt” contains the list of found payments, 
  one payment per line, sorted in ascending order. If no solution is found,
  the file will contain the text “NO SOLUTION” on the first line. 
   
For the above example, the output file would contain:  
17.09 
22.75 
34.22

●  executable jar file “find_payments.jar” which receives the input file path 
   as argument, and produces the file output.txt.  