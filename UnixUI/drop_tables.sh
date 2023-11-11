#!/bin/sh
#export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib
sqlplus64 "avle/04160188@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle12c.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl12c)))" <<EOF

DROP TABLE accessories;
DROP TABLE cardescription;
DROP TABLE cardropoff;
DROP TABLE carpickup;
DROP TABLE coverage;
DROP TABLE cusdetails;
DROP TABLE cusinsurance;
DROP TABLE customer;
DROP TABLE paymentdetails;
DROP TABLE promotion;
DROP TABLE purchasedetails;
DROP TABLE reservation;
DROP TABLE services;
