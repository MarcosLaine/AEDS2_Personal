#pedi para o chat gpt criar um código que salva a ultima posição trocada do bubble sort, o que faz com que ele realize um troca a menos, desnecessária.
#isso foi questão de prova, eu não soube fazer no inicio, pedi para que mostrasse graficamente

import matplotlib.pyplot as plt
import numpy as np
import time

def bubble_sort_visual(array):
    n = len(array)
    
    # Cria a figura e o gráfico inicial
    fig, ax = plt.subplots()
    bars = ax.bar(range(len(array)), array, color="blue")
    plt.title("Bubble Sort - Visualização")

    def update_bars(array, bars):
        for bar, val in zip(bars, array):
            bar.set_height(val)
        plt.pause(0.3)  # Controla a velocidade da animação

    # Variável para controlar até onde precisa verificar trocas
    last_unsorted = n - 1
    
    
    #bubble sort em si
    for i in range(n - 1):
        ultimoTroca = 0
        for j in range(last_unsorted):  # Agora verificamos apenas até `last_unsorted`
            if array[j] > array[j + 1]:
                # Troca os elementos
                array[j], array[j + 1] = array[j + 1], array[j]
                ultimoTroca = j + 1

            # Atualiza a visualização após cada comparação
            update_bars(array, bars)

        # Se não houve trocas, o array já está ordenado
        if ultimoTroca == 0:
            break

        # Atualiza o limite do próximo loop para a última posição trocada
        last_unsorted = ultimoTroca

    # Mostra o array final ordenado
    plt.show()

if __name__ == "__main__":
    # Gera um array aleatório para a visualização
    array = np.random.randint(1, 100, 15)
    print("Array original:", array)
    
    bubble_sort_visual(array)
    
    print("Array ordenado:", array)
