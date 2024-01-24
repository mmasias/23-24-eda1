Estoy trabajando en el plantUML: 
@startuml
class ValoresNutricionales{
int calorias;
int azucares;
int proteinas;
int grasas;
String tipo;

public ValoresNutricionales(int calorias, int azucar, int proteinas, int grasas, String tipo);
public int getCalorias();
public void setCalorias(int calorias);
public int getAzucar();
public void setAzucar(int azucar);
public int getProteinas();
public void setProteinas(int proteinas);
public int getGrasas();
public void setGrasas(int grasas);
public String getTipo();
public void setTipo(String tipo);
@Override public int compareTo(ValoresNutricionales o);
}

class NodoArbol <T extends DatosArbol> {
private T valor;
private GenericList<nodoArbol<T>> hijos;

public NodoArbol(T valor);
@Override public int compareTo(NodoArbol<T> o);
public T getValor();
public void setValor(T valor);
public GenericList<NodoArbol<T>> getHijos();
public void setHijos(GenericList<NodoArbol<T>> hijos);
public void insertarHijo(NodoArbol<T> hijo);
}

class paciente{
String nombre;
LocalDate fecha;

public Paciente(String nombre, LocalDate fecha);
public String getNombre();
public void setNombre(String nombre);
public LocalDate getFecha();
public void setFecha(LocalDate fecha);
@override public String getInfo();
}

class main{}

class Ingesta i{
Horario horario;
GenericList<Alimento> alimentos;

public Ingesta(Horario horario);
public Horario getHorario();
public void setHorario(Horario horario);
public GenericList<Alimento> getAlimentos();
public void insertarAlimento(Alimento alimento);
@Override public int compareTo(Ingesta o);
@Override public String getInfo();
public void vaciar();
public double totalCalorias();
public double totalGrasas();
public double totalAzucar();
public double totalProteinas();
public int totalTipo();
}

class Informacion{
public static ValoresNutricionales getDatos(String nombre);
}

enumHorario{DESAYUNO, MEDIAMAÑANA, ALMUERZO, MERIENDA, CENA}

class Gestion{
private Arbol<DatosArbol> arbol;
private Scanner sc;
private DateTimeFormatter formato;

public Gestion();
public void insertarPaciente();
public void insertarEncuesta();
public void insertarDia();
public void insertarIngesta();
public void capturarDatos();
public void mostrar();
public NodoArbol<DatosArbol> existeNodoIngesta(int dia, Horario horario);
public void Estadisticas();
}

class GenericNode<T>{
private T value;
private GenericNode<T> next;

public GenericNode(T value);
public T getValue();
public void setValue(T newValue);
public GenericNode<T> getNext();
public void setNext(GenericNode<T> siguiente);
}

class GenericList<T>{
private GenericNode<T> first = null;
public int size();
public boolean isEmpty();
}
@enduml
