let Node = class {
  constructor(d) {
    this.data = d;
    this.next = null;
  }
};

let linkList = class {
  constructor() {
    this.head = null;
  }
  add(data) {
    let cur;
    let node = new Node(data);
    if (this.head == null) {
      this.head = node;
    } else {
      cur = this.head;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = node;
    }
  }
  printList() {
    let temp = this.head;
    if (temp == null) {
      console.log("LinkList is empty");
    }
    while (temp != null) {
      console.log(temp.data);
      temp = temp.next;
    }
  }
  // Insert a node at beginning of linkList
  insertAtBeg(value) {
    let temp = new Node(value);
    temp.next = this.head;
    this.head = temp;
  }

  // Insert a node at end of linkList
  insertAtEnd(value) {
    let temp = new Node(value);
    let cur = this.head;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = temp;
  }

  // Insert a node after a particular node of linkList
  // yaha element mtlb kis node ke baad dalna h
  insertAfter(element, data) {
    let cur = this.head;
    while (cur.data != element) {
      cur = cur.next;
    }
    let temp = new Node(data);
    temp.next = cur.next;
    cur.next = temp;
  }

  insertBefore(element, data) {
    let prev = null;
    let cur = this.head;
    while (cur.data != element) {
      prev = cur;
      cur = cur.next;
    }
    let temp = new Node(data);
    temp.next = cur;
    prev.next = temp;
  }

  deleteAtbeg() {
    this.head = this.head.next;
  }

  deleteAtEnd() {
    let cur = this.head;
    let prev = null;
    while (cur.next != null) {
      prev = cur;
      cur = cur.next;
    }
    prev.next = null;
  }

  deleteANode(element) {
    let prev = null;
    let cur = this.head;
    while (cur.data != element) {
      prev = cur;
      cur = cur.next;
    }
    prev.next = cur.next;
  }

  deleteBefore(element) {
    let cur = this.head;
    if (element === cur.next.data) {
      cur.next=this.head;
    } else {
      cur=this.head
      let prepre = null;
      let prev = null;
      while (cur.data != element) {
        prepre = prev;
        prev = cur;
        cur = cur.next;
      }
      prepre.next = prev.next;
    }
  }

  deleteAfter(element) {
    let cur = this.head;
    while (cur.data != element) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
  }
};

let l1 = new linkList();
l1.add(1);
l1.add(2);
l1.add(3);
l1.insertAtEnd(4);
l1.insertAtBeg(5);
l1.insertBefore(3, 6);
l1.insertAfter(1, 7);
l1.deleteBefore(6);
// l1.deleteBefore(1);
l1.printList();
