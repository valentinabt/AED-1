package aed;

public class Agenda {
    private Fecha fechaDeHoy ;
    private ArregloRedimensionableDeRecordatorios recordatorios_ ;

    public Agenda(Fecha fechaActual) {
        fechaDeHoy = new Fecha(fechaActual) ;
        recordatorios_ = new ArregloRedimensionableDeRecordatorios() ;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
      if( recordatorio != null) {
        recordatorios_.agregarAtras(recordatorio);

      }
    }

    @Override
    public String toString() {
       StringBuffer a = new StringBuffer() ;
       a.append(fechaDeHoy) ;
       a.append("\n") ; //va con barrita 
       a.append("=====") ;
       a.append("\n") ;
       for(int j = 0 ; j < recordatorios_.longitud() ; j++) {
        if(recordatorios_.obtener(j).fecha().equals( fechaDeHoy) ) {
        a.append(recordatorios_.obtener(j)) ;
        a.append("\n") ;
       }
      }
      return a.toString() ;
    }

    public void incrementarDia() {
     Fecha fechaDemañana = new Fecha(fechaDeHoy) ;
     fechaDemañana.incrementarDia() ;
     fechaDeHoy = fechaDemañana ;

    }

    public Fecha fechaActual() {
        return new Fecha(fechaDeHoy.dia(),fechaDeHoy.mes()) ;
    }

}
