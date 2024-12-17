package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    Nodo raiz ;
    int cardinal ;
    int altura ;
    
    private class Nodo {
        // Agregar atributos privados del Nodo
        Nodo izquierdo ;
        Nodo derecho ;
        Nodo padre ;
        T valor ;
       
        Nodo(T n) {
            this.valor = n ;
            this.izquierdo = null ;
            this.derecho = null ;
            this.padre = null ;
        }

        
    }

    public ABB() {
        this.raiz = null ;
        this.cardinal = 0 ;

        
    }

    public int cardinal() {
       return this.cardinal ;
     
    }

    public T minimo(){
        Nodo actual = raiz ;
        while(actual.izquierdo != null) {
            actual = actual.izquierdo ;
            
        } 
        return actual.valor ;
    }

    public T maximo(){
        Nodo actual = raiz ;
       
        while(actual.derecho != null) {
            actual = actual.derecho ;
            
        } 
        return actual.valor ;
      
    }

    public void insertar(T elem){
        Nodo actual = raiz ;
        //Nodo nuevo = new Nodo(elem) ; si pertenece,para que lo creo ?
        
        if(!pertenece(elem)){
            Nodo nuevo = new Nodo(elem) ;
            while(!pertenece(elem)) {
            
                if(raiz == null) {
                    raiz = nuevo;
                            }
                else {
                    if(actual.valor.compareTo(elem)>0) {
                        if(actual.izquierdo != null) {
                        actual = actual.izquierdo ;
                            } else {
                             actual.izquierdo = nuevo ;
                                nuevo.padre = actual ;
                            }
                    } else {
                        if(actual.derecho != null) {
                            actual = actual.derecho ;
                     } else {
                            actual.derecho = nuevo ;
                            nuevo.padre = actual ;
                        }
                    }
            } }cardinal += 1 ; 
        
        }
             }
         
    

    public boolean pertenece(T elem){
        Nodo actual = raiz ;
        while(actual != null) {
            if(elem.compareTo(actual.valor) == 0) {
                return true ;
            }
            else if(elem.compareTo(actual.valor) > 0) {
                actual = actual.derecho ;
            }
            else {
                actual = actual.izquierdo ;
                }
            }
        
        return false ;
        }

    public void eliminar(T elem){
        Nodo actual = raiz ;
        //busco el nodo
        if(pertenece(elem)) {
          while(actual!= null && actual.valor.compareTo(elem)!=0) {
            if(actual.valor.compareTo(elem)>0) {
                actual = actual.izquierdo ;
            } else {
                actual = actual.derecho ;
            }
          }
         
        }
        //sale del if y el else con actual.valor = t 

        while(pertenece(elem)) {
            if(actual.derecho == null && actual.izquierdo == null) {
                if(raiz == actual) {
                    //si es raiz,no tiene padre
                    raiz = null ;
                } else {
                    if(actual == actual.padre.izquierdo) {
                        actual.padre.izquierdo = null ; //lo desconecto del padre
                    } else {
                        actual.padre.derecho = null ;
                    }
                }
            }
            else if(actual.derecho != null && actual.izquierdo == null) {
                if(actual == raiz) {
                    raiz = actual.derecho ; //convierto en raiz al unico hijo 
                    //actual.derecho.padre = null ;  //es necesario aclararlo ? es raiz,obvio que no va tener padre por lñas dudas no
                    
                   
                }
                else {
                    if(actual.padre.izquierdo == actual) { //actual es el hijo izquierdo
                        actual.padre.izquierdo = actual.derecho ;
                        actual.derecho.padre = actual.padre ; //conecto el unico hijo con el padre 

                    }
                    else {
                        actual.padre.derecho = actual.derecho ;
                        actual.derecho.padre = actual.padre ;
                    
                    }
                }
            }
            else if (actual.derecho == null && actual.izquierdo != null) {
                if(actual == raiz) {
                    actual.izquierdo.padre = null ;
                    raiz = actual.izquierdo ;
                } else {
                    if(actual == actual.padre.derecho) {
                       actual.padre.derecho = actual.izquierdo ;
                       actual.izquierdo.padre = actual.padre ;
                    }
                    else {
                        actual.padre.izquierdo = actual.izquierdo ;
                        actual.izquierdo.padre = actual.padre ;
                    }
                }
            }
            else {
                //como tiene un hijo derecho,va a entrar en el primer caso de Sucesor,el sucesor no va a tener hijo izquierdo porque el sucesor es el mas a la izquierda. 
                //o el sucesor tiene un hijo derecho o bien el sucesor no tiene hijos 
                //como sabemos que el sucesor es el mas a la izquierda,sabemos que es el hijo izquierdo de su padre 
                    Nodo sucesorNodo = Sucesor(actual) ;
                    if(Sucesor(actual).derecho != null) { 
                        if(sucesorNodo.padre == actual) {
                            sucesorNodo.padre.derecho = sucesorNodo.derecho ;
                            sucesorNodo.derecho.padre = sucesorNodo.padre ;
                            actual.valor = sucesorNodo.valor ; //antes este caso no estaba y era necesario
                        } else {
                        sucesorNodo.padre.izquierdo= sucesorNodo.derecho ;
                       sucesorNodo.derecho.padre = sucesorNodo.padre ;
                        actual.valor = sucesorNodo.valor ; 
                    
                        }
                    }
                    else { 
                        //no tiene hijos
                       if(Sucesor(actual).padre == actual) {
                         actual.valor = sucesorNodo.valor ;
                         actual.derecho = null ; //creo que ahi si se deesconecta
                       }
                        else {
                            sucesorNodo.padre.izquierdo = null ;
                            actual.valor = sucesorNodo.valor ;
                        }
                        
                    }

               
            } 


        } cardinal -= 1 ;
        
    }
                 
                
            
            
                
        
     private Nodo Sucesor(Nodo t) {
     Nodo actual = t ;
     if(t.valor == maximo()) {
        return actual ;
     }

     if(actual.derecho != null) { 
        actual = actual.derecho ;
        while(actual.izquierdo != null) {
            actual = actual.izquierdo ;
        }
        return actual ;
    } else {
       if(actual.padre != null) {
         if(actual.padre.derecho == actual) {
            while(actual.padre != null && actual.padre.derecho == actual) { //tengo que buscar hasta llegar al padre que sea hijo izquierdo de su padre
                actual = actual.padre ;
            }
            if(actual.padre != null) {
                actual = actual.padre ;
            }
         }
         else {
            actual = actual.padre ;
         }
       }
       }
       return actual ;
    }
       
    
    

    public String toString(){ 
        Nodo actual = raiz ;
        int j = 0 ;
        int i = cardinal -1 ;
        StringBuffer conjunto = new StringBuffer() ;
        conjunto.append("{") ;
       while(actual.izquierdo != null) {
             actual = actual.izquierdo ;
       }
        while(j<=i) {
            conjunto.append(actual.valor) ;
            conjunto.append(",") ;
            actual = Sucesor(actual) ;
            j ++ ;
        }
        //conjunto.append(actual.valor) ;
        conjunto.deleteCharAt(conjunto.length()-1) ;
        conjunto.append("}") ;
       return conjunto.toString() ;
    }
   

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual ;
        public ABB_Iterador() {
            _actual = raiz ;
            while(_actual.izquierdo != null) {
                _actual = _actual.izquierdo ;
            }
        }
        
        public boolean haySiguiente() { 
            if(_actual.valor != maximo()) {
                return true ;
            }  
            return false ;        
           
        }
    
        public T siguiente() {
            T res ;
            if(haySiguiente()) {
                res = _actual.valor ;
                _actual = Sucesor(_actual) ;
            } else {
                 res = _actual.valor ;
            }
            return res ;
    }
 }
    public Iterador<T> iterador() {
        
       return new ABB_Iterador() ;
    }
    
    
   


}
