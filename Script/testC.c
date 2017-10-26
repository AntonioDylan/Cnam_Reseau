#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

const char * quiSuisJe=NULL;

int creatFile(void){
	char nom[20], car;
	FILE *fic;
	printf("entrez le nom du fichier");
	scanf ("%s", nom);
	if ((fic=fopen(nom, "w"))==NULL)
		printf("Erreur de création");
	else
		while(car=getchar() != EOF)
			fputc(car, fic);
	fclose(fic); 
}


int readFile(void){
	char nom[20], car;
	FILE *fic;
	printf("entrez le nom du fichier");
	scanf ("%s", nom);
	if ((fic=fopen(nom, "r"))==NULL)
		printf("Erreur d’ouverture");
	else
		while(car=fgetc(fic) != EOF)
			putchar(car);
	fclose(fic);
}

void forkTest(){
	pid_t pid ;
	quiSuisJe= "le père";
	pid=fork();
	if (pid==0){
		quiSuisJe="le fils";
		printf("je suis %s \n", quiSuisJe);
	}
	else
		printf("je suis %s \n", quiSuisJe);

}

void main()
{
	forkTest();
}