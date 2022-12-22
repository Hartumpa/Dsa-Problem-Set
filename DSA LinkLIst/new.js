class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
  }

  insertFirst(data) {
    const node = new Node(data, this.head);
    this.head = node;
  }

  size() {
    let counter = 0;
    let node = this.head;
    while (node) {
      counter++;
      node = node.next;
    }
    return counter;
  }

  getFirst() {
    return this.head.data;
  }

  getLast() {
    if (!this.head) {
      return null;
    }
    let node = this.head;
    while (node) {
      if (!node.next) {
        return node;
      }
      node = node.next;
    }
  }

  clear() {
    this.head = null;
  }

  removeFirst() {
    if (!this.head) {
      return;
    }
    this.head = this.head.next;
  }
  removeLast() {
    if (!this.head) {
      return;
    }

    if (!this.head.next) {
      this.head = null;
    }

    let previous = this.head;
    let node = this.head.next;

    while (node.next) {
      previous = node;
      node = node.next;
    }

    previous.next = null;
  }
  insertLast(data) {
    const last = this.getLast();
    if (last) {
      last.next = new Node(data);
    } else {
      this.head = new Node(data);
    }
  }

  getAt(index) {
    let counter = 0;
    let node = this.head;
    while (node) {
      if (counter === index) {
        return node;
      }
      counter++;
      node = node.next;
    }
    return null;
  }
  removeAt(index) {
    if (!this.head) {
      return;
    }
    if (index === 0) {
      this.head = this.head.next;
      return;
    }

    const previous = this.getAt(index - 1);
    if (!previous || !previous.next) {
      return;
    }
    previous.next = previous.next.next;
  }
  insertAt(data, index) {
    if (!this.head) {
      this.head = new Node(data);
      return;
    }
    if (index === 0) {
      this.head = new Node(data, this.head);
      return;
    }
    const previous = this.getAt(index - 1) || this.getLast();
    const node = new Node(data, previous.next);
    previous.next = node;
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

  reverse() {
    let cur = this.head;
    let prev = null;
    let aage = null;
    while (cur != null) {
      aage = cur.next;
      cur.next = prev;
      prev = cur;
      cur = aage;
    }
    this.head = prev;
    return this.head;
  }
}

let l1 = new LinkedList();
l1.add(1);
l1.add(2);
l1.add(3);
l1.add(4);
l1.add(5);
l1.insertFirst(6);
l1.insertLast(7);
l1.reverse();
l1.printList();
// (l1.reverse())
// l1.clear()
// console.log("first: " + l1.getFirst());
// // console.log("Last: " + l1.getLast());
// console.log("size: " + l1.size());


