create table Home (
    id int not null,
    streetAddress varchar(50) not null,
    directCentralStation varchar(25) not null,
    nearestStation varchar(25) not null,
    numBedrooms int not null,
    numBathrooms int not null,
    walkTimeToStation int not null,
    timeToCentral int not null,
    notes varchar(500)
);