package menu;

import javax.swing.JOptionPane;
public class Menu {
    static int l;
int n, A[],i,j, aux;

    void pedirTamano() 
    {
    n=Integer.parseInt(JOptionPane.showInputDialog("Tamaño del arreglo? "));   
    System.out.println("El tamaño del arreglo es de..... "+n);
    }
       void llenarArreglo ()
                {
        A= new int[n];
        for(i=0; i<=n-1; i++ )
      A[i]=Integer.parseInt(JOptionPane.showInputDialog("Dame el valor de la posicion "+(i+1)+":")); 
        
         l=A.length-1;
    }        
       void burbuja()
       {
         for(i=1; i<n; i++)
             for(j=0; j<=n-(i+1); j++)
                 if(A[j] > A[j+1])
         {
           aux=A[j];
           A[j]=A[j+1];
           A[j+1]=aux;
       }
       }
       void imprime()
       {
           String salida="";
    salida = "El Arreglo Ordenado es ";
           for(i=0; i<A.length;i++){
               salida=salida+"["+A[i]+"] ";
           }
            
            JOptionPane.showMessageDialog(null, salida);
               JOptionPane.showMessageDialog(null, "El esta Arreglo ordenado "+A[i]); 
       }
  void inte(){     
for(i=1;i<A.length;i++){
	aux=A[i];
	j=i-1;
while((j>=0)&&(aux<A[j])){
	A[j+1]=A[j];
j--;
}
A[j+1]=aux;
}
}
  void shell(){
        int salto;
        boolean cambio;
        for(salto=A.length/2; salto!=0; salto/=2){
            cambio=true;
            while(cambio){
                cambio=false;
                for(i=salto; i<A.length; i++){
                    if(A[i-salto]>A[i]){
                        aux=A[i];
                        A[i]=A[i-salto];
                        A[i-salto]=aux;
                        cambio = true;
                    }
                }
            }
        }
    }
  void select(){
            int min=i,pos=0;
           for(i=0; i<n-1; i++){
               min=A[i];
               pos=i;
                  for(j=i+1; j<=n-1; j++){
                     if(min>A[j]){
                        min=A[j];
                        pos=j;
           aux=A[i];
           A[i]=min;
           A[pos]=aux;
                        }
               }
           }

  }
  
  void quicksort(int izq, int der) {
    int pivote=A[izq];
    i=izq; 
    j=der; 
    while(i<j){
        while(A[i]<=pivote && i<j) i++; 
            while(A[j]>pivote) j--;     
                if (i<j) {              
                    aux= A[i];          
                    A[i]=A[j];
                    A[j]=aux;
                    }
        }
        A[izq]=A[j]; 
        A[j]=pivote; 
        if(izq<j-1)
            quicksort(izq,j-1); 
        if(j+1 <der)
            quicksort(j+1,der); 
    }
  
  void hamont(int mov, int end){
        int izq=2*mov+1;
        int der=izq+1;
        int may;
        if(izq>end)
            return;
        if(der>end)
            may=izq;
        else
            may=A[izq]>A[der]?izq:der;
        if(A[mov]<A[may]){
            int tmp=A[mov];
            A[mov]=A[may];
            A[may]=tmp;
            hamont(may,end);
        }           
    }
    void monticulo(){
        final int m=A.length;
        for(int move=m/2;move>=0;move--)
            hamont(move,m-1);
        for(int mo=m-1;mo>=0;mo--){
            int tmp=A[0];
            A[0]=A[mo];
            A[mo]=tmp;
            hamont(0,mo-1);
        }
                    
    }
  

  
    public static void main(String[] args) {
        int res=0;
        res=Integer.parseInt(JOptionPane.showInputDialog(
                "Elije una opcion: \n;"
                + " a) Burbuja \n;"
                + " b) Insercion \n ;"
                + "c) Seleccion \n;"
                + " d)Shell \n;"
                + " e)Quicksort"
                + " f)monticulo \n;"));
        Menu objeto= new Menu();     
        
switch(res){
        case 1:
        objeto.pedirTamano();
        objeto.llenarArreglo();
        objeto.burbuja();
        objeto.imprime();
break;
case 2: 
    objeto.pedirTamano();
    objeto.llenarArreglo();
    objeto.inte();
    objeto.imprime();
    break;
case 3: 
    objeto.pedirTamano();
    objeto.llenarArreglo();
    objeto.select();
    objeto.imprime();
    break;
   case 4: 
    objeto.pedirTamano();
    objeto.llenarArreglo();
    objeto.shell();
    objeto.imprime();
    break;
    
    case 5:
                objeto.pedirTamano();
                objeto.llenarArreglo();
                objeto.quicksort(1,1);
                objeto.imprime();
                break;
                
                case 6:
                objeto.pedirTamano();
                objeto.llenarArreglo();
                objeto.monticulo();
                objeto.imprime();
                break;

default: 
    
}
}
}