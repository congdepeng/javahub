package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/EndpointInfoListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../../src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Wednesday, December 18, 2013 6:34:37 PM PST
*/


/** A list of endpoint information for a particular ORB.  
    */
public final class EndpointInfoListHolder implements org.omg.CORBA.portable.Streamable
{
  public com.sun.corba.se.PortableActivationIDL.EndPointInfo value[] = null;

  public EndpointInfoListHolder ()
  {
  }

  public EndpointInfoListHolder (com.sun.corba.se.PortableActivationIDL.EndPointInfo[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.sun.corba.se.PortableActivationIDL.EndpointInfoListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.sun.corba.se.PortableActivationIDL.EndpointInfoListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.sun.corba.se.PortableActivationIDL.EndpointInfoListHelper.type ();
  }

}
