package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero ;
    private Nodo ultimo ;
    private int size ;

    private class Nodo {
        private Nodo siguiente ;
        private Nodo anterior ;
        private T elemento ;

        Nodo(T valor) {
            elemento = valor ;
        }

    }

    public ListaEnlazada() {
        primero = null ;
        ultimo = null ;
        size = 0 ;
        
    }

    public int longitud() {
        return size ;
    }

    public void agregarAdelante(T elem) {
        if(size == 0){
            Nodo nuevo = new Nodo(elem) ;
            nuevo.anterior = null ;
            nuevo.siguiente = null ;
            nuevo.elemento = elem ;
            primero = nuevo ;
            ultimo = nuevo ;
            size = 1 ;
        } else {
        Nodo nuevo = new Nodo(elem) ;
        nuevo.siguiente = primero ;
        primero.anterior = nuevo ;
        primero = nuevo ;
        size += 1 ;
        nuevo.anterior = null ;
        }


    }

    public void agregarAtras(T elem) {
        if( size == 0 ) {
             agregarAdelante(elem);
           
        } else {
            Nodo nuevo = new Nodo(elem) ;
            ultimo.siguiente = nuevo ;

            nuevo.siguiente = null ;
            nuevo.anterior = ultimo ;
            nuevo.elemento = elem ;
            size += 1 ;
            ultimo = nuevo ;
        }
    }

    public T obtener(int i){
        Nodo actual = primero ;
        if(i< size ) {
            if(i == 0 ){
                return primero.elemento ;
            }
            int j = 0 ;
            while(j<i && actual.siguiente != null) {
                actual = actual.siguiente ;
                j += 1 ;

            }
        } return actual.elemento ;
    }

    public void eliminar(int i) {
        Nodo actual = primero ; 
        if(i < size) {
            if(i == 0 ) { //habra alguna forma de hacer esto mas efectivo ?
                if(actual.siguiente != null) {
                    primero = actual.siguiente ;
                }
                else {
                    primero = null ;
                }
            }
            


            else if(i == size -1) {
                 ultimo = ultimo.anterior ;
                 //ultimo.siguiente = null ;
                
            } else {
            int j = 0 ;
            while(j<i && actual.siguiente != null ) {
                actual = actual.siguiente ;
                j += 1 ;
            }
            Nodo antes = actual.anterior ;
            Nodo sigue = actual.siguiente ;
            antes.siguiente = sigue ;
            sigue.anterior = antes ;
            }
        }
        size = size -1 ;
    }

    public void modificarPosicion(int indice, T elem) {
    
     Nodo actual = primero ;
     for(int j = 0 ; j < indice ; j++) {

        actual = actual.siguiente ;
     } 
     actual.elemento = elem ; 
  
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nueva = new ListaEnlazada<T>() ;
        Nodo actual = primero ;
        for(int j = 0 ; j<size ; j++) {
            T elemen = actual.elemento ;
            nueva.agregarAtras(elemen) ;
            actual = actual.siguiente ;
        } 
        nueva.size = size ;
        return nueva ;

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
       if(lista != null ) {
        primero = lista.primero ;
        ultimo = lista.ultimo ;
        size = lista.size ;
       }
        
   
    }
    
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer() ;
        res.append("[") ;
        Nodo actual = primero ;
        for(int j = 0 ;j < size -1 ; j++) {
         res.append(actual.elemento) ;
         res.append(",") ;
         res.append(" ") ;
         actual = actual.siguiente ; }
            res.append(actual.elemento) ;
             res.append("]") ;
            return res.toString() ;
    }

    private class ListaIterador implements Iterador<T> {
    	private int dedo ;

        ListaIterador() {
            dedo = 0 ;

        }
        public boolean haySiguiente() {
	        return (!(dedo == size-1 )) ;
        }
        
        public boolean hayAnterior() {
	        return(!(dedo==0)) ;
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
