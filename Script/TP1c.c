#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <unistd.h>
#include <sys/types.h>
struct hostent * gethostbyname(const char * name); 
void forkTest();

void main(){
	forkTest();
}

void forkTest(){
	pid_t pid1,pid2;
	int i1 =1,i2 = 51;
	pid1=fork();
	if (pid1==0){
		while(i1<51){
			printf("F1 i = %d \n ", i1);
			i1++;
		}
		exit(0);
	}
	int * statut = NULL;
	int i = wait(statut);
	while(i2<101){
		printf("F2 i = %d \n ", i2);
		i2++;		
	}
}




void hostName(){
	char nom[20];	
	printf("entrez le nom de l'host\n");
	scanf ("%s", nom);
	struct hostent * host = gethostbyname(nom);
	int i = 0;
	while(host->h_addr_list[i] != NULL){
		printf("%s\n", inet_ntoa(*(struct in_addr *)(host->h_addr_list[i])) );
		i++;
	}
}