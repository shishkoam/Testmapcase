package shishkoam.testmapcase;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by ав on 12.06.2016
 */
public class ListHolder {

    private ArrayList<Boolean> selectedVerses = new ArrayList<>();

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> addresses = new ArrayList<>();
    private ArrayList<Double> distances = new ArrayList<>();
    private ArrayList<Double> costs = new ArrayList<>();
    private int selectedNumber = 0;

    public ListHolder(Context context, ArrayList<MapObject> values) {
        for (MapObject obj : values) {
            names.add(obj.name);
            addresses.add(obj.address);
            selectedVerses.add(false);
        }
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void removeSelected(Context context) {
        for (int i = 0; i < selectedVerses.size(); i++) {
            if (selectedVerses.get(i)) {
                selectedNumber--;
            }
        }

        for (int i = 0; i < selectedVerses.size(); i++) {
            selectedVerses.set(i, false);
        }
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }

    public ArrayList<Double> getDistances() {
        return distances;
    }

    public String getFilename(int pos) {
        return names.get(pos);
    }

    public void setFilenames(ArrayList<String> filenames) {
        this.names = filenames;
    }

    public boolean isSelected(int position) {
        return selectedVerses.get(position);
    }

    public void setSelected(Integer position, boolean state) {
        if (state) {
            selectedNumber++;
        } else {
            selectedNumber--;
        }
        selectedVerses.set(position, state);
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    public String getSelectedText() {
        int size = names.size();
        String result = "";
        for (int i = 0; i < size; i++) {
            if (selectedVerses.get(i)) {
                result += names.get(i) + "\n";
            }
        }
        return result;
    }

}