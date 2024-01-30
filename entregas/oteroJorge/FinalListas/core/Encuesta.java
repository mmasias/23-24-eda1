public class Encuesta {

    private String fechaDeAlta;

    public Encuesta(String fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void mostrarArbol(Paciente paciente){
        System.out.println("Paciente: " + paciente.getNombre() );
        System.out.println("Fecha de alta: " + getFechaDeAlta());
        paciente.imprimirLista();
        

    }


    
    
}
