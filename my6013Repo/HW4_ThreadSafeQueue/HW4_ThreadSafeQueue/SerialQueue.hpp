#pragma once

template <typename T>
class SerialQueue{
private:
  struct Node{
	T data;
	Node* next;
  };

  Node* head;
  Node* tail;
  int size_;

public:
  SerialQueue()
	:head(new Node{T{}, nullptr}), size_(0) // head is always dummy node
  {
	tail = head;
  }


  void enqueue(const T& x){
      Node* temp = new Node;
      temp->data = x;
      temp->next = nullptr;
      
      tail->next = temp;
      tail = temp;
      
      size_++;
      
  }

  bool dequeue(T* ret){

      Node* temp = head->next;
      if( temp == nullptr ){ // if empty before dequeue
          return false;
      }
      
      head->next = temp->next;
      if(head->next == nullptr){ // if empty after dequeue
          tail = head;
      }
      
      *ret = temp->data;
      delete temp;
      
      size_--;
      return true;
  }

  ~SerialQueue(){

	while(head){
	  Node* temp = head->next;
	  delete head;
	  head = temp;
	}
  }

  int size() const{ return size_;}  
};
