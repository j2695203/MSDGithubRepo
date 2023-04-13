#ifndef ConcurrentQueue_h
#define ConcurrentQueue_h
//#include <mutex>

template <typename T>
class ConcurrentQueue{
private:
    
    struct Node{
        T data;
        Node* next;
    };
    
    Node* head;
    Node* tail;
    std::atomic<int> size_;
    
    std::mutex head_m, tail_m;

public:
    ConcurrentQueue()
    :head(new Node{T{}, nullptr}), size_(0) // head is always dummy node
    {
        tail = head;
    }


    void enqueue(const T& x){
        Node* temp = new Node;
        temp->data = x;
        temp->next = nullptr;
        
        tail_m.lock();
        tail->next = temp;//
        tail = temp;//
        size_++;//?
        tail_m.unlock();
        
    }

    bool dequeue(T* ret){
        
        head_m.lock();
        Node* temp = head->next;//
        if( temp == nullptr ){ // if empty before dequeue
            head_m.unlock();
            return false;
        }
          
        head->next = temp->next;//
        if(head->next == nullptr){ // if empty after dequeue
            tail_m.lock(); // tail has data race between enqueue and dequeue (head_m doesn't lock tail)
            tail = head;//
            tail_m.unlock();
        }//
          
        *ret = temp->data;//
        size_--;//?
        head_m.unlock();
        
        delete temp;
        return true;
    }

    ~ConcurrentQueue(){
        while(head){
            Node* temp = head->next;
            delete head;
            head = temp;
        }
    }

    int size() const{ return size_;}
};

#endif /* ConcurrentQueue_h */
