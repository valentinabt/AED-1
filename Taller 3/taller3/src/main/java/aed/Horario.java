package aed;

public class Horario {
    private int hora_ ;
    private int minutos_ ;
    public Horario(int hora, int minutos) {
        hora_ = hora ;
        minutos_ = minutos ;
    }

    public int hora() {
        return hora_ ;
    }

    public int minutos() {
        return minutos_ ;
    }

    @Override
    public String toString() {
         StringBuffer a = new StringBuffer() ;
         a.append(hora_) ;
         a.append(":") ;
         
         a.append(minutos_) ;
            
         
         return(a.toString()) ;
    }

    @Override
    public boolean equals(Object otro) {
        boolean cd = (this.getClass() != otro.getClass()) ;
        boolean en = otro == null ;
        if (en || cd) {
            return false ;
        }
        Horario otrohorario = (Horario) otro ;
        return( hora_ ==(otrohorario.hora_) && minutos_==(otrohorario.minutos_) ) ;
        }

}
