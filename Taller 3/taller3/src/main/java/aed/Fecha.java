package aed;

public class Fecha {
  //atributos,instancias de una clase 
    private int _mes ;
    private int _dia ;
    //constructor 
    public Fecha(int dia, int mes) {
         _dia = dia ;
         _mes = mes ;


    }
    public Fecha(Fecha fecha) {
       _mes = fecha._mes ;
       _dia = fecha._dia ;
    }
    public Integer dia() {
        
        return _dia ;
    }

    public Integer mes() {
        
        return _mes ;
    }
    @Override
    public String toString() {
        StringBuffer nose = new StringBuffer();
        nose.append(_dia) ;
        nose.append("/") ;
        nose.append(_mes) ;
        return nose.toString();

    }
//quiza esto de error después
    @Override
    public boolean equals(Object otra) {
       boolean ci = ( otra.getClass() != this.getClass() ) ;
       boolean ne = otra == null ;
       if (ci || ne) {
        return false ;
       } 
       Fecha otrafecha = (Fecha) otra  ;
       return( _mes == otrafecha._mes&& _dia == (otrafecha._dia) ) ;       

    }
//preguntar esto 
    public void incrementarDia() {
      if (_mes == 12 && _dia == diasEnMes(_mes)) {
        _dia = 01 ;
        _mes = 01 ;
      } else if(_dia == diasEnMes(_mes)) {
        _mes = _mes + 1 ;
        _dia = 1 ;

      } else {
        _dia = _dia + 1 ;
      }
    }

    private int diasEnMes(int mes) {
        int dias[] = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
               
        return dias[mes-1];
    }
    

}
