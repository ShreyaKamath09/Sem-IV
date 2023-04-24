#vi StudentRecords
Roll no.  Batch   Surname  Firstname  Marks
01        S11     Bafna    Abhigyan    18
02        S11     Chavarkar Rudrani    19
03        S12     Chowdhry  Maryam     13
04        S12     Dohadwala Huzefa     15
05        S13     Kamath    Shreya     19
06        S13     Samberkar Jay        11
07        S13     Joshi     Niranjan   17
08        S14     Kapse     Meetali    16
09        S14     Marathe   Darshil    15
10        S14     Kamath    Shaunak    20

#display first 3 columns
awk '{print $1 $2 $3}' StudentRecords.lst

#display surname name and marks
awk '{print $3 $4 $5}' StudentRecords 

#display records of students with marks higher than 15
awk '$5>15' StudentRecords

#transfer these to a different file and display that file
awk '$5>15' StudentRecords>GoodMarks.lst 
vi GoodMarks.lst


