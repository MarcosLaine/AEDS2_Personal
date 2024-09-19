#include <stdio.h>
#include <string.h>

int main(){
    int n;
    scanf("%d", &n);
    int vetor[n];
    for(int i = 0; i < n; i++){
        scanf("%d", &vetor[i]);
    }

    while (n>1){

        for(int i = 0; i < n-1; i++){
            if(vetor[i] == vetor[i+1])
                vetor[i] = 1;
            else    
                vetor[i] = -1;
        }
        n--;
        
    }
    if(vetor[0] == 1)
        printf("preta\n");
    else
        printf("branca\n");
    

    return 0;
}