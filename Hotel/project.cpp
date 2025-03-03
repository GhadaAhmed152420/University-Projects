#include<iostream>
#include<fstream>
#include<string.h>
using namespace std;
//programe to assist hotels in registering guest data.
void insert(){        //register guest data.
	fstream hotel;
char name[30],mobile[30],country[30],
email[30],roomtype[20],roomprice[20],
dateofarrival[20],dateofdeparture[20];
	hotel.open("hotel.txt",ios::app);  
	cout<<"name: ";          
	cin>>name;
	cout<<"mobile: ";
	cin>>mobile;
	cout<<"country: ";
	cin>>country;
	cout<<"email: ";
	cin>>email;
	cout<<"room type: ";
	cin>>roomtype;
	cout<<"room price: ";
	cin>>roomprice;
	cout<<"date of arrival: ";
	cin>>dateofarrival;
	cout<<"date of departure: ";
	cin>>dateofdeparture;
	hotel<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
	cout<<"done!\n";
	hotel.close();
}
void update(){            //edit guest data.
	fstream hotel;
	fstream help;
hotel.open("hotel.txt",ios::in);
help.open("help.txt",ios::out);
	char name[30],mobile[30],country[30],email[30],roomtype[20],roomprice[20],dateofarrival[20],dateofdeparture[20],r[20];
cout<<"enter mobile of guest to update record: ";
cin>>r;
while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');                                                                               
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	if(strcmp(mobile,r)==0){
	cout<<"enter new data of record\n";	
	cout<<"name: ";
	cin>>name;
	cout<<"mobile: ";
	cin>>mobile;
	cout<<"country: ";
	cin>>country;
	cout<<"email: ";
	cin>>email;
	cout<<"room type: ";
	cin>>roomtype;
	cout<<"room price: ";
	cin>>roomprice;
	cout<<"date of arrival: ";
	cin>>dateofarrival;
	cout<<"date of departure: ";
	cin>>dateofdeparture;
	help<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
	<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
	}
else
{
		help<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
		<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
}	
}
help.close();
hotel.close();
remove("hotel.txt");
rename("help.txt","hotel.txt");
cout<<"done!\n";
}
void search(){            //find a guest by phone number.
	fstream hotel;
hotel.open("hotel.txt",ios::in);
char name[30],mobile[30],country[30],email[30],roomtype[20],
roomprice[20],dateofarrival[20],dateofdeparture[20],r[20];
cout<<"enter the mobile to search about it: ";
cin>>r;
cout<<"\n name*mobile*country*email*room type*room price*date of arrival*date of departure\n";
while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	if(strcmp(mobile,r)==0){
	cout<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
	<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
	
	}
}
hotel.close();
cout<<"done!\n";
}
void query(){        //make a questionnaire for guest in the hotel by theguest name.
fstream hotel;
hotel.open("hotel.txt",ios::in);
char name[30],mobile[30],country[30],email[30],roomtype[20],
roomprice[20],dateofarrival[20],dateofdeparture[20],r[20];
cout<<"enter the name to do the query: ";
cin>>r;
cout<<"\n name*mobile*country*email*room type*room price*date of arrival*date of departure\n";
while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	if(strcmp(name,r)==0){
	cout<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
	<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
	continue;
}
	}
cout<<"done!\n";
hotel.close();
}
void display(){          //show all guests data in hotel.
	fstream hotel;
	hotel.open("hotel.txt",ios::in);
	char name[30],mobile[30],country[30],email[30],roomtype[20],
	roomprice[20],dateofarrival[20],dateofdeparture[20];
	cout<<"\n name*mobile*country*email*room type*room price*date of arrival*date of departure\n";
	while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	cout<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
	<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
}
cout<<"done!\n";
hotel.close();
}
void del(){         //delete guest data by phone number.
	fstream hotel;
	fstream help;
hotel.open("hotel.txt",ios::in);
help.open("help.txt",ios::out);
char name[30],mobile[30],country[30],email[30],roomtype[20],
roomprice[20],dateofarrival[20],dateofdeparture[20],r[20];
cout<<"enter mobile of guest to do delete: ";
cin>>r;
while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	if(strcmp(mobile,r)==0){
		continue;
	}
	else{
		help<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
		<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
}
hotel.close();
help.close();
remove("hotel.txt");
rename("help.txt","hotel.txt");
cout<<"done!\n";
}
}
void report(){        //making a report about room type,country.
int h;
cout<<"choose number that you want to do report about it: \n ";
cout<<"1.room type.\n 2.country.\n";
cout<<"write your choose: ";
cin>>h;
if(h=1){
		fstream hotel;
hotel.open("hotel.txt",ios::in);
char name[30],mobile[30],country[30],email[30],roomtype[20],
roomprice[20],dateofarrival[20],dateofdeparture[20],r[20];
cout<<"enter the room type to do the report: ";
cin>>r;
cout<<"\n name*mobile*country*email*room type*room price*date of arrival*date of departure\n";
while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	if(strcmp(roomtype,r)==0){
	cout<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
	<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
	continue;
	}
}
cout<<"done!\n";
hotel.close();
}
else
{
	fstream hotel;
hotel.open("hotel.txt",ios::in);
char name[30],mobile[30],country[30],email[30],roomtype[20],roomprice[20],dateofarrival[20],dateofdeparture[20],r[20];
cout<<"enter the country to do the report: ";
cin>>r;
cout<<"\n name*mobile*country*email*room type*room price*date of arrival*date of departure\n";
while(!hotel.eof()){
	hotel.getline(name,30,'*');
    hotel.getline(mobile,30,'*');
	hotel.getline(country,30,'*');
	hotel.getline(email,30,'*');
	hotel.getline(roomtype,20,'*');
	hotel.getline(roomprice,20,'*');
	hotel.getline(dateofarrival,20,'*');
	hotel.getline(dateofdeparture,20);
	if(strcmp(country,r)==0){
	cout<<name<<'*'<<mobile<<'*'<<country<<'*'<<email<<'*'<<roomtype
	<<'*'<<roomprice<<'*'<<dateofarrival<<'*'<<dateofdeparture<<'\n';
	continue;
	}
}
cout<<"done";
hotel.close();
}
}
int main(){
	bool z=true;
	while(z){
		cout<<"choose the number of what you want to do: \n";
		cout<<" 1.insert.\n 2.update.\n 3.search.\n 4.query.\n 5.display.\n 6.delete.\n 7.report.\n";
		cout<<"write your choose: ";
		int x;
		cin>>x;
		switch(x){
			case 1:
				insert();
			break;
			case 2:
				update();
			break;
			case 3:
				search();
			break;
			case 4:
				query();
				break;
			case 5:
				display();
			break;
			case 6:
				del();
				break;
			case 7:
			 report();
				break;
			default:
		cout<<"choose right number\n";
		}
	cout<<"if you want to do another thing press'&'\n";
	char y;
	cin>>y;
	if(y!='&'){
		z=false;
	}
	}
}

