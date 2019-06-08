package fr.elie.screen.fields.tables;
import fr.elie.content.Animal;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class AnimauxTable extends JTable{

    public AnimauxTable(Object[] objects) {
        this.setModel(new Model(objects));
        getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void moveColumn(int column, int targetColumn) {
        //On empêche le déplacement d'une colonne
    }

    private class Model extends AbstractTableModel {

        private final String[] entete = {"#", "Nom", "Age","Sexe","ok_chien","ok_chat","ok_enfant","date_creation","race","pelage", "traitement"};
        private final Object[] objects;

        public Model(Object[] list) {
            this.objects = list;
        }

        /**
         * Returns the number of rows in the model. A
         * <code>JTable</code> uses this method to determine how many rows it
         * should display.  This method should be quick, as it
         * is called frequently during rendering.
         *
         * @return the number of rows in the model
         * @see #getColumnCount
         */
        @Override
        public int getRowCount() {
            return objects.length;
        }

        /**
         * Returns the number of columns in the model. A
         * <code>JTable</code> uses this method to determine how many columns it
         * should create and display by default.
         *
         * @return the number of columns in the model
         * @see #getRowCount
         */
        @Override
        public int getColumnCount() {
            return entete.length;
        }

        @Override
        public String getColumnName(int column) {
            return (String) this.entete[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
            Animal item = (Animal) objects[rowIndex];

            switch (columnIndex) {
                case 0:
                    return "    " + item.getId();
                case 1:
                    return item.getNom();
                case 2:
                    return item.getAge();
                case 3:
                    return item.getSexe();
                case 4:
                    return item.getOkChien();
                case 5:
                    return item.getOkChat();
                case 6:
                    return item.getOkEnfant();
                case 7:
                    return item.getDateCreation();
                case 8:
                    return item.getRace();
                case 9:
                    return item.getPelage();
                case 10:
                    return item.getTraitement();
            }
            return "";
        }
    }
}