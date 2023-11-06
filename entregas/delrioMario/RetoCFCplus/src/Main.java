public class Main {
    public static void main(String[] args) {
        List item1 = new List();
        List item2 = new List();
        List item3 = new List();
        List item4 = new List();
        List item5 = new List();
        List caja1 = new List();
        List caja2 = new List();
        List caja3 = new List();
        List caja4 = new List();
        List caja5 = new List();
        List cola = new List();
        boolean libre1, libre2, libre3, libre4, libre5, activa;
        int probItems = (int) ((Math.random() * 100) % 11 + 5);
        int minutosDia = 12 * 60;
        libre1 = true;
        libre2 = true;
        libre3 = true;
        libre4 = true;
        libre5 = true;
        activa = false;
        int minutosSinCola = 0;
        boolean llegaAlguienNuevo = false;
        int pItem1 = 0;
        int pItem2 = 0;
        int pItem3 = 0;
        int pItem4 = 0;
        int pItem5 = 0;

        for (int tiempo = 1; tiempo < minutosDia; tiempo++) {
            if (Math.random() * 100 < 40) {
                llegaAlguienNuevo = true;
                if (llegaAlguienNuevo == true) {
                    cola.insert(1);
                    if (libre1) {
                        caja1.insert(pItem1++);
                        libre1 = false;
                        item1.insert(probItems);
                        cola.deleteMidSide(cola.size());
                    } else if (libre2) {
                        caja2.insert(pItem2++);
                        libre2 = false;
                        item2.insert(probItems);
                        cola.deleteMidSide(cola.size());
                    } else if (libre3) {
                        caja3.insert(pItem3++);
                        libre3 = false;
                        item3.insert(probItems);
                        cola.deleteMidSide(cola.size());
                    } else if (libre4) {
                        caja4.insert(pItem4++);
                        libre4 = false;
                        item4.insert(probItems);
                        cola.deleteMidSide(cola.size());
                    } else if (libre5 && activa) {
                        caja5.insert(pItem5++);
                        libre5 = false;
                        item5.insert(probItems);
                        cola.deleteMidSide(cola.size());
                    }
                }
                if (item1.size() > 0) {
                    item1.deleteMidSide(item1.size());
                    if (item1.size() == 0) {
                        libre1 = true;
                    }
                }
                if (item2.size() > 0) {
                    item2.deleteMidSide(item2.size());
                    if (item2.size() == 0) {
                        libre2 = true;
                    }
                }
                if (item3.size() > 0) {
                    item3.deleteMidSide(item3.size());
                    if (item3.size() == 0) {
                        libre3 = true;
                    }
                }
                if (item4.size() > 0) {
                    item4.deleteMidSide(item4.size());
                    if (item4.size() == 0) {
                        libre4 = true;
                    }
                }
                if (item5.size() > 0) {
                    item5.deleteMidSide(item5.size());
                    if (item5.size() == 0) {
                        libre5 = true;
                    }
                }
                if (cola.size() == 0) {
                    minutosSinCola++;
                }
            }
            System.out.println("--------------------------------------------------------------");
            System.out.print("MIN " + tiempo);
            if (llegaAlguienNuevo) {
                System.out.println(" - LLega 1 persona - En cola: " + cola.size());

            } else {
                System.out.println(" - No llega nadie - En cola: " + cola.size());
            }
            if (cola.size() == 0) {
                minutosSinCola++;
            }
            System.out.print(" Caja1:[" + item1.size() + "] | Caja2:[" + item2.size() + "] | Caja3:[" + item3.size() + "] | Caja4:[" + item4.size() + "]");
            if (item5.size() > 0 || activa) {
                System.out.println(" Caja5:[" + item5.size() + "] ");
            } else {
                System.out.println();
            }

            if (cola.size() >= 15) {
                activa = true;
            } else {
                activa = false;
            }


            System.out.println("La cola ha estado vacia durante " + minutosSinCola + " minutos");

        }
    }
}