package aed;

class Funciones {
    int cuadrado(int x) {
        int respuesta = x*x ;
        return respuesta;
    }

    double distancia(double x, double y) {
        double modulo = x*x + y*y ;
        double respuesta = Math.sqrt(modulo) ;
        return respuesta;
    }

    boolean esPar(int n) {
        boolean respuesta ;
        if (n%2==0) {
            respuesta = true ; 
        } else {
            respuesta = false ;
        }
        return respuesta;
    }

    boolean esBisiesto(int n) {
        boolean respuesta = (((n%4==0)&& !(n%100==0)) || (n%400==0)) ;
        return respuesta;
    }

    int factorialIterativo(int n) {
        int contador = 1 ;
        int respuesta = 1 ;
        while (contador <=n ) {
            respuesta = contador * respuesta ;
            contador +=1 ;

        }
        return respuesta;
    }

    int factorialRecursivo(int n) {
        int respuesta = 1 ;
        if (n==0) {
            respuesta = 1 ;
        } else {
            respuesta = n*factorialRecursivo(n-1) ;
        }
        return respuesta ;
    }

    boolean esPrimo(int n) {
        boolean respuesta = true ;
        if (n==0 || n==1) {
            respuesta = false ;
        } else if (n==2) {
            respuesta = true ;
        } else {
            for (int contador = 2 ; contador <n; contador +=1) {
                if (n%contador==0) {
                    respuesta = false ;
                }
            }
        }
        
        return respuesta ;
    }

    int sumatoria(int[] numeros) {
        int suma = 0 ;
        for (int x :numeros) {
            suma += x ;

        }
        return suma;
    }

    int busqueda(int[] numeros, int buscado) {
        int resultado = 0 ;
        for (int posicion = 0 ; posicion<numeros.length ; posicion+= 1) {
            if (numeros[posicion] == buscado) {
              resultado += posicion ;
            } 
        }

        return resultado ;
    }

    boolean tienePrimo(int[] numeros) {
     boolean resultado = false ;
     for (int elemento : numeros) {
        if (esPrimo(elemento)) {
            resultado = true ;
        }
     }
        return resultado ;
    }

    boolean todosPares(int[] numeros) {
       boolean respuesta = true ;
        for (int indice= 0 ; indice< numeros.length ; indice++ ) {
            if (! esPar(numeros[indice])) {
            respuesta = false ;
            }
        }  
       return respuesta ;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean respuesta = true ;
        if (s2.length()<s1.length()) {
            respuesta = false ;
        } else {
            for (int i = 0 ; (i<s1.length() && i<s2.length()) ; i ++) {
                if ((s1.charAt(i) !=s2.charAt(i))) {
                    respuesta = false ;
                }
        }
        
        }
        return respuesta;
    }

    boolean esSufijo(String s1, String s2) {
       boolean respuesta = true ;
       if(s2.length()< s1.length()) {
          respuesta = false ;
       } else {
       for(int i = 0 ; i < s1.length() ; i += 1) { 
            if (s1.charAt(s1.length()-1-i) != s2.charAt(s2.length()-1-i)) { //acá se le resta uno porque sino se va de rango.
            respuesta = false ;
        }
       } 
       
    } return respuesta ;
    }

        
      
}
