#include <stdio.h>

int main(){

    int metrosPraia, sorveteiros;

    // O loop continua enquanto metrosPraia ou sorveteiros forem diferentes de 0
    while(scanf("%d %d", &metrosPraia, &sorveteiros) == 2 && (metrosPraia != 0 || sorveteiros != 0)) {
        int inicioSorveteiro, fimSorveteiro;
        for(int i = 0; i < sorveteiros; i++){
            scanf("%d %d", &inicioSorveteiro, &fimSorveteiro);
        }
    }

    return 0;
}
