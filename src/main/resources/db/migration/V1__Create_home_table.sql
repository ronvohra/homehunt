create table Home (
    id int not null,
    url varchar(500) not null,
    rent int not null,
    streetAddress varchar(50) not null,
    numBedrooms int not null,
    numBathrooms int not null,
    nearestStation varchar(25) not null,
    walkTimeToStation int not null,
    directCentralStation varchar(25) not null,
    timeToCentral int not null,
    notes varchar(500)
);
