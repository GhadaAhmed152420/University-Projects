#include<iostream>
#include<fstream>
#include<string.h>
using namespace std;

void Add_Book(){       
	fstream library;
char ISBN[10],Book_Name[30],Auther_Name[30],
Publisher_Name[30],Year_of_publishing[5],Edition_Number[3];
	library.open("library.txt",ios::app);  
	cout<<"ISBN: ";          
	cin>>ISBN;
	cout<<"Book_Name: ";
	cin>>Book_Name;
	cout<<"Auther_Name: ";
	cin>>Auther_Name;
	cout<<"Publisher_Name: ";
	cin>>Publisher_Name;
	cout<<"Year_of_publishing: ";
	cin>>Year_of_publishing;
	cout<<"Edition_Number: ";
	cin>>Edition_Number;
	cout<<"do you want to:\n 1.redo.\n 2.undo.\n";
	cout<<"write your choose: ";
	int x;
	cin>>x;
	switch(x){
		case 1:
	library<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
	cout<<"done!\n";
	library.close();
	break;
	case 2:
		cout<<"done!\n";
	library.close();
	break;
	}

}
void Update_Book(){            
	fstream library;
	fstream help;
library.open("library.txt",ios::in);
help.open("help.txt",ios::out);
	char ISBN[10],Book_Name[30],Auther_Name[30],
Publisher_Name[30],Year_of_publishing[5],Edition_Number[2],r[10];
cout<<"Enter ISBN to update Book: ";
cin>>r;
while(!library.eof()){
	library.getline(ISBN,10,'*');
    library.getline(Book_Name,30,'*');
	library.getline(Auther_Name,30,'*');
	library.getline(Publisher_Name,30,'*');                                                                               
	library.getline(Year_of_publishing,5,'*');
	library.getline(Edition_Number,3);
	if(strcmp(ISBN,r)==0){
		cout<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
	cout<<"enter new data of Book\n";	
	cout<<"ISBN: ";
	cin>>ISBN;
	cout<<"Book_Name: ";
	cin>>Book_Name;
	cout<<"Auther_Name: ";
	cin>>Auther_Name;
	cout<<"Publisher_Name: ";
	cin>>Publisher_Name;
	cout<<"Year_of_publishing: ";
	cin>>Year_of_publishing;
	cout<<"Edition_Number: ";
	cin>>Edition_Number;
	help<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
	}
else
{
		help<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
}	
}
help.close();
library.close();
cout<<"do you want to:\n 1.redo.\n 2.undo.\n";
cout<<"write your choose: ";
	int x;
	cin>>x;
	switch(x){
		case 1:
				remove("library.txt");
rename("help.txt","library.txt");
cout<<"done!\n";
	break;
	case 2:
cout<<"done!\n";
break;
}
}
void Find_Book(){            
	fstream library;
library.open("library.txt",ios::in);
	char ISBN[10],Book_Name[30],Auther_Name[30],
Publisher_Name[30],Year_of_publishing[5],Edition_Number[3],r[10];
cout<<"Enter ISBN to search about Book: ";
cin>>r;
cout<<"\n ISBN*Book_Name*Auther_Name*Publisher_Name*Year_of_publishing*Edition_Number \n";
while(!library.eof()){
	library.getline(ISBN,10,'*');
    library.getline(Book_Name,30,'*');
	library.getline(Auther_Name,30,'*');
	library.getline(Publisher_Name,30,'*');                                                                               
	library.getline(Year_of_publishing,5,'*');
	library.getline(Edition_Number,3);
	if(strcmp(ISBN,r)==0){
	cout<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
	
	}
}
library.close();
cout<<"done!\n";
}

void Display_Books(){         
	fstream library;
	library.open("library.txt",ios::in);
	char ISBN[10],Book_Name[30],Auther_Name[30],
Publisher_Name[30],Year_of_publishing[5],Edition_Number[3];
cout<<"\n ISBN*Book_Name*Auther_Name*Publisher_Name*Year_of_publishing*Edition_Number \n";
	while(!library.eof()){
	library.getline(ISBN,10,'*');
    library.getline(Book_Name,30,'*');
	library.getline(Auther_Name,30,'*');
	library.getline(Publisher_Name,30,'*');                                                                               
	library.getline(Year_of_publishing,5,'*');
	library.getline(Edition_Number,3);
	cout<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
}
cout<<"done!\n";
library.close();
}
void Delete_Book(){         
	fstream library;
	fstream help;
library.open("library.txt",ios::in);
help.open("help.txt",ios::out);
char ISBN[10],Book_Name[30],Auther_Name[30],
Publisher_Name[30],Year_of_publishing[5],Edition_Number[3],r[10];
cout<<"Enter ISBN to Delete a Book: ";
cin>>r;
while(!library.eof()){
	library.getline(ISBN,10,'*');
    library.getline(Book_Name,30,'*');
	library.getline(Auther_Name,30,'*');
	library.getline(Publisher_Name,30,'*');                                                                               
	library.getline(Year_of_publishing,5,'*');
	library.getline(Edition_Number,3);
	if(strcmp(ISBN,r)==0){
		continue;
	}
	else{
		help<<ISBN<<'*'<<Book_Name<<'*'<<Auther_Name<<'*'<<
	Publisher_Name<<'*'<<Year_of_publishing<<'*'<<Edition_Number<<'\n';
}}
library.close();
help.close();
cout<<"do you want to:\n 1.redo.\n 2.undo.\n";
cout<<"write your choose: ";
	int x;
	cin>>x;
	switch(x){
		case 1:
remove("library.txt");
rename("help.txt","library.txt");
cout<<"done!\n";
	break;
	case 2:
cout<<"done!\n";
break;
}
}
void Exit(){
	exit(0);
}
int main(){
	bool z=true;
	while(z){
		cout<<"***********************************************Library Management System************************************************\n";
		cout<<"choose the number of what you want to do: \n";
		cout<<" 1.Add_Book.\n 2.Update_Book.\n 3.Find_Book.\n 4.Display_Books.\n 5.Delete_Book.\n 6.Exit.\n ";
		cout<<"write your choose: ";
		int x;
		cin>>x;
		switch(x){
			case 1:
				Add_Book();
			break;
			case 2:
				Update_Book();
			break;
			case 3:
				Find_Book();
			break;
			case 4:
				Display_Books();
				break;
			case 5:
				Delete_Book();
			break;
			case 6:
				Exit();
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

