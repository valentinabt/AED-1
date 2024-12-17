package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] arreglo_ ;
    private int largo_ ;
    
    public ArregloRedimensionableDeRecordatorios() {
      largo_ = 0 ;
      //arreglo_ = new Recordatorio[0] ;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {

      if (vector != null) {
         arreglo_ = vector.arreglo_ ;
         largo_ = vector.largo_ ;
      }
   }

    public int longitud() {
      return largo_ ;
    }

   public void agregarAtras(Recordatorio i) {
     Recordatorio[] nuevo = new Recordatorio[largo_+1] ;
     if(i != null) {
      for(int j = 0 ; j< largo_ ; j++) {
         nuevo[j] = arreglo_[j] ; 
      }
      nuevo[largo_] = i ;
      largo_ = largo_ +1 ;
      arreglo_ = nuevo ;
   } else {
      nuevo = arreglo_ ;
      arreglo_ = nuevo ;

   }
   } 


    /*public void agregarAtras(Recordatorio i) {
    Recordatorio[] nuevoarreglo = new Recordatorio[largo_+1] ;
      if(i != null) {
       int j = 0 ;
       while(j<largo_) {
          nuevoarreglo[j] = arreglo_[j] ;
          j = j +1 ;
          if(j==largo_) {
            nuevoarreglo[j] = i ;
          }
          }
          largo_ = largo_ + 1 ;
          arreglo_ = nuevoarreglo ;
       } */
       
       

   

    public Recordatorio obtener(int i) {
        return arreglo_[i] ;                //supongo que me dan un i valido,osea dentro del rango.
    }





    public void quitarAtras() {
        // voy a hacer lo mismo que agregar atras pero sacando un elemento y listo.
        Recordatorio[] nuevoarreglo = new Recordatorio[largo_-1] ;
        int j = 0 ;
        while(j<largo_-1) {
            nuevoarreglo[j] = arreglo_[j] ;
            j = j+1 ;
             }
        arreglo_ = nuevoarreglo ;  
        largo_ = largo_ -1 ;   
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
       Recordatorio[] nuevoarreglo = new Recordatorio[largo_] ;
       for(int j = 0 ; j <= indice ; j++) {
         if(j==indice) {
            nuevoarreglo[j] = valor ;
         } else {
            nuevoarreglo[j] = arreglo_[j] ;
         }
       }
       for(int j=indice+1;j< largo_;j++) {
          nuevoarreglo[j] = arreglo_[j] ;
       } 
       arreglo_ = nuevoarreglo ;
      } 

    /*public ArregloRedimensionableDeRecordatorios copiar() {
       ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios() ;
       copia.arreglo_ = arreglo_ ;
      return copia ;
    } */
    public ArregloRedimensionableDeRecordatorios copiar() {
      ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios() ;
      Recordatorio[] copiarr = new Recordatorio[largo_] ;
      copia.largo_ = largo_ ;
      for(int j = 0 ; j < largo_ ; j++) {
         copiarr[j] = arreglo_[j] ;

      }
      copia.arreglo_ = copiarr ;
      return copia ;
    }

}
