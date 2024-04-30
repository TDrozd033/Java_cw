enum ErrCode { STACK_IS_EMPTY, OTHER_ERROR}
// obiekty wewnatrz klasy

// zamiast wskaznikow uzywamy referencji
class StackException extends RuntimeException
{
    private ErrCode  mErrCode = ErrCode.OTHER_ERROR;

    public StackException( ErrCode errCode)
    {
        mErrCode = errCode;
    }
    public String getReason()
    {
        switch(mErrCode)
        {
            case STACK_IS_EMPTY: return " Stack is Empty \n";
            default: return "Other error\n";
        }
    }
}
public class Stack
{
    private class StackItem
    {
        private char mKey;
        private StackItem mNext;

        public StackItem( char c, StackItem next)
        {
            mKey = c;
            mNext = next;
        }

        public char getKey() {
            return mKey;
        }

        public StackItem getNext() {
            return mNext;
        }
    }

    private StackItem mHead = null;

    public void push( char c)
    {
        mHead = new StackItem( c, mHead);

    }
    public char  pop() throws StackException
    {
        if( isEmpty())
        {
            throw new StackException( ErrCode.STACK_IS_EMPTY);
        }
        char c = top();
        del();
        return c;
    }
    public char top() throws StackException
    {
        if( !isEmpty())
        {
            return mHead.getKey();
        }
        throw new StackException(ErrCode.STACK_IS_EMPTY);
    }
    public void del() throws StackException
    {
        if( isEmpty())
        {
            throw new StackException(ErrCode.STACK_IS_EMPTY);
        }
        mHead = mHead.getNext();
    }

    public boolean isEmpty()
    {
        return mHead == null;
    }
}
