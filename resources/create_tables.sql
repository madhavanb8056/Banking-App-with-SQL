create table TransactionHistory(
	id bigint primary key auto_increment,
	AccountNumber bigint not null,
	TransactionDate date not null,
	WithdrawAmount int,
	DepositAmount int,
	Balance bigint not null,
	foreign key (AccountNumber) references users(AccountNumber)
);

create table users(
	AccountNumber bigint primary key,
	Name varchar(30) Not Null,
	PinNumber int Not Null,
	PhoneNumber bigint,
	Address varchar(50),
	Balance bigint
);