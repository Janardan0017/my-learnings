#include<iostream>
using namespace std;

#define FLP(i,a,b) for(int i=a; i<b; i++)

void ifElse(int n){
	if(n%2==0){
		cout<<"Even number"<<endl;
	}else{
		cout<<"Odd number"<<endl;
	}
}

int main(){
	FLP(i,1,11){
		cout<<i<<endl;
	}
	int n;
	cin>>n;
	ifElse(n);
	return 0;
}