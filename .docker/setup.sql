CREATE DATABASE IF NOT EXISTS DNDdb;

CREATE USER IF NOT EXISTS "dndAdmin"@"%" IDENTIFIED BY "Brumbo2";
GRANT ALL ON DNDdb.* TO "dndAdmin"@"%";

CREATE USER IF NOT EXISTS "dndService"@"%" IDENTIFIED BY "Brumbo3";
GRANT INSERT, SELECT, DELETE, UPDATE ON DNDdb.* TO "dndService"@"%";
