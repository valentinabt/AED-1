package aed;

public class Recordatorio {
    private Fecha fecha_ ;
    private String mensaje_ ;
    private Horario horario_ ;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        mensaje_ = mensaje ;
        
        fecha_ = new Fecha(fecha) ;
        horario_ = horario ;
    }
    
    public Fecha fecha() {
      return new Fecha(fecha_) ;

    }

    public String mensaje() {
        return mensaje_ ;
    }

    public Horario horario() {
        return horario_ ;
    }
    @Override
    public String toString() {
        StringBuffer b = new StringBuffer() ;
        b.append(mensaje_) ;
        b.append(" ") ;
        b.append("@") ;
        b.append(" ") ;
        b.append(fecha_) ;
        b.append(" ") ;
        b.append(horario_) ;
        return b.toString() ;
        }

    @Override
    public boolean equals(Object otro) {
        if(otro == null || this.getClass() != otro.getClass()){
            return false ;
        }
        Recordatorio otrorecordatorio = (Recordatorio) otro ;
        return(fecha_.equals(otrorecordatorio.fecha_) && mensaje_.equals(otrorecordatorio.mensaje_) && horario_.equals(otrorecordatorio.horario_) ) ;
    }

}
