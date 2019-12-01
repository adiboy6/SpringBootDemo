psql -U postgres << eof
\\c demodb;
create extension "uuid-ossp";
eof