import static org.junit.Assert.*;

public class VectorHeapTest {


    @org.junit.Test
    public void add() {
        //se agregan 2 pacientes a el vector heap
        VectorHeap orden = new VectorHeap();
        Paciente paciente = new Paciente("Kristen","dolor de cabeza","C");
        orden.add(paciente);
        Paciente pac = new Paciente("Amanda","Pierna rota","A");
        orden.add(pac);
        assertEquals(orden.getData(),orden.data);
    }

    @org.junit.Test
    public void remove() {
        //se agregan 2 pacientes a el vector heap
        VectorHeap orden = new VectorHeap();
        Paciente paciente = new Paciente("Kristen","dolor de cabeza","C");
        orden.add(paciente);
        Paciente pac = new Paciente("Amanda","Pierna rota","A");
        orden.add(pac);
        orden.remove();
        // se quita el primer paciente en este caso Amanda
        assertEquals(orden.getData(),orden.data);

    }
}