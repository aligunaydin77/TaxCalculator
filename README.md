Problem statement
This assessment consists in writing a simple application that prints out the details of a receipt containing items purchased by a customer. The receipt should list the number of items, the name, the final price (including taxes) of each of the item purchased, plus two extra lines showing the total amount of the receipt and the total amount of taxes.
<br />
Taxes are calculated with a rate of 17.5%, rounding the result to the upper 0.05. Please note that medical products are exempt and an additional 1.25 fixed amount is added as an extra tax on CDs
<br />
What you need to provide
We expect you to provide a working solution to the problem, at least for the scenarios provided; it may just consist of hard coded data in a set of unit tests. Please note that input/output or persistency are NOT required, concentrate your efforts on a good design.
<br />
Examples
Input:<br />
one book at 29.49<br />
one music CD at 15.99 <br />
one chocolate snack at 0.75<br />
Output:<br /> 
1 book: 34.69<br /> 
1 music CD: 20.04<br />
1 chocolate snack: 0.90<br /> 
Sales Taxes: 9.40<br /> 
Total: 55.63<br />

Input:<br /> 
one bottle of wine at 20.99<br /> 
one box of tooth ache pills at 4.15<br /> 
one box of pins at 11.25<br /> 
one music CD at 14.99<br />
Output:<br /> 
1 bottle of wine: 24.69<br /> 
1 box of headache pills: 4.15<br /> 
1 box of pins: 13.25<br /> 
1 music CD: 18.89<br /> 
Sales Taxes: 9.60<br /> 
Total: 60.98<br />
