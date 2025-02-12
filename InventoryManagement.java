package AssignmentLinkList;

class Main3
{
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        inventory.addAtBeginning("Laptop", 101, 5, 750);
        inventory.addAtEnd("Phone", 102, 10, 500);
        inventory.insertAtSpecificPosition(2,"Tablet", 103, 7, 300);
        inventory.displayInventory();
        System.out.println("Total Inventory Value: " + inventory.calculateTotalInventoryValue());
        inventory.displayInventory();
    }
}

class node {
    String ItemName;
    int ItemId;
    int Quantity;
    int Price;
    node next;

    public node(String ItemName, int ItemId, int Quantity, int Price) {
        this.ItemName = ItemName;
        this.ItemId = ItemId;
        this.Quantity = Quantity;
        this.Price = Price;
    }
}


public class InventoryManagement
{
    private node head;

    public void addAtBeginning(String ItemName, int ItemId, int Quantity, int Price) {
        node nod = new node( ItemName, ItemId, Quantity, Price);
        nod.next = head;
        head = nod;
    }

    public void addAtEnd(String ItemName, int ItemId, int Quantity, int Price) {
        node node = new node(ItemName, ItemId, Quantity, Price);
        if (head == null) {
            head = node;
            return;
        }
        AssignmentLinkList.node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void insertAtSpecificPosition(int position, String ItemName, int ItemId, int Quantity, int Price) {
        node new_node = new node(ItemName, ItemId, Quantity, Price);
        if (position == 1) {
            new_node.next = head;
            head = new_node;
        }
        else
        {
            node previous = head;
            int count = 1;
            while (count < position - 1)
            {
                previous = previous.next;
                count++;
            }
            node current = previous.next;
            new_node.next = current;
            previous.next = new_node;
        }
    }


    public void removeByItemId (int ItemId)
    {
        if (head == null) return;
        if (head.ItemId == ItemId) {
            head = head.next;
            return;
        }
        node temp = head, prev = null;
        while (temp != null && temp.ItemId != ItemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    public node SearchByItemId(String ItemName, int ItemId)
    {
        if (head == null) {
            System.out.println("No record found!!");
            return null;
        }


        node temp = head;
        while (temp != null) {
            if (temp.ItemName == ItemName || temp.ItemId == ItemId) {
                System.out.println("Record Found");
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public double calculateTotalInventoryValue()
    {
        double totalValue = 0;
        node temp = head;
        while (temp != null) {
            totalValue += temp.Quantity * temp.Price;
            temp = temp.next;
        }
        return totalValue;
    }

    public void displayInventory() {
        node temp = head;
        while (temp != null) {
            System.out.println(", Name: " + temp.ItemName + "ID: " + temp.ItemId + ", Quantity: " + temp.Quantity + ", Price: " + temp.Price);
            temp = temp.next;
        }
    }

}
