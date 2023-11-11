#!/bin/sh

function pause(){
   read -p "$*"
}


MainMenu()
{
while [ "$CHOICE" != "START" ]
do
clear
echo
"================================================================="
echo "| Car Rental DBMS
|"
echo "| Published by: Andrew Le, Audrey Chen, Jugadbeer Sangha, Nivaethan Piratheepan
|"
echo "| Main Menu - Select Desired Operation(s):
|"
echo "| <CTRL-Z Anytime to Enter Interactive CMD Prompt>
|"
echo "-----------------------------------------------------------------"
echo " $IS_SELECTED1 1) Create Tables"
echo " $IS_SELECTED2 2) Drop Tables"
echo " $IS_SELECTED3 3) Populate Tables"
echo " $IS_SELECTED4 4) List Queries"
echo " $IS_SELECTED5 5) View Queries"
echo "-----------------------------------------------------------------"
echo " $IS_SELECTED0 0) End/Exit"
echo "Choose: "
read CHOICE
if [ "$CHOICE" == "1" ]
then
bash create_tables.sh
Pause
elif [ "$CHOICE" == "2" ]
then
bash drop_tables.sh
Pause
elif [ "$CHOICE" == "3" ]
then
bash populate_tables.sh
Pause
elif [ "$CHOICE" == "4" ]
then
bash list_q.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "5" ]
then
bash list_v.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "Q" ]
then
bash q1.sh 
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "W" ]
then
bash q2.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "E" ]
then
bash q3.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "R" ]
then
bash q4.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "T" ]
then
bash q5.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "Y" ]
then
bash q6.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "U" ]
then
bash q7.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "I" ]
then
bash q8.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "O" ]
then
bash q9.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "P" ]
then
bash q10.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "A" ]
then
bash q11.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "S" ]
then
bash q12.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "D" ]
then
bash q13.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "F" ]
then
bash q14.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "G" ]
then
bash q15.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "H" ]
then
bash q16.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "J" ]
then
bash q17.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "K" ]
then
bash q18.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "L" ]
then
bash q19.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "B" ]
then
bash q20.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "N" ]
then
bash q21.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "M" ]
then
bash q22.sh
pause 'Press [Enter] key to continue...'



elif [ "$CHOICE" == "Z" ]
then
bash v1.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "X" ]
then
bash v2.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "C" ]
then
bash v3.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "V" ]
then
bash v4.sh
pause 'Press [Enter] key to continue...'
elif [ "$CHOICE" == "0" ]
then
exit
fi
done
}
#--COMMENTS BLOCK--
# Main Program
#--COMMENTS 
BLOCK--
ProgramStart()
{
StartMessage
while [ 1 ]
do
MainMenu
done
}
ProgramStart
