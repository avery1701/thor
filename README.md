﻿#  ThOR - Java Test Object Recorder

The Java Test Object Recorder (ThOR) project provides four "object recorders" 
to record live object trees or behavior for playback during unit testing.  

Object recorders enable the recording of state or behavior so that data 
retrieved from a remote system, or possibly a complex object graph, can be 
easily reconstructed or mocked to facilitate unit testing.

The latest release is version 1.6.0. Recent changes include:

    Convert to gradle build
    Update to EasyMock 3.5.1
    Addition of the MockBeanRecorder
    ClassWriter.setSuperClass() method to control the factory super class
    MockBehaviorRecorder.setNice() method to create "nice" mock objects
    	instead of the default "strict" mocks
    Default support for BigDecimal and BigInteger object creation in state 
    	recorders
    Objenesis object creation support in state recorders
    BeanRecorder.stopDescent( Class ) method to prevent inspection from 
    	continuing descent on a class

There are two types of object recorders, state and behavior recorders.

State recorders record the entire object graph in either a Java factory class 
or XML file.

Behavior recorders record only the methods that are called on the live object 
tree in a factory class that will construct a tree of mock objects that will 
replicate the recorded behavior.

## State Recorders:

com.advancedpwr.record.BeanRecorder – This recorder will records an object 
tree that follows the Java Bean convention.  It is particularly useful for
recording web service return structures since generated web service stubs
normally follow this convention.  The BeanRecorder can be extended to support
the construction of objects that require arguments in the constructor by 
implementing a MethodWriterFactory and adding an instance to the recorder.
This method of recording has the advantage that the resulting factory class 
is entirely Java and will “follow” refactorings such as method, class or 
package renaming.  No additional jar files are necessary to use this recorder.

com.advancedpwr.record.xtream.XstreamRecorder – This implementation uses 
Xstream to create a factory that stores the object tree in an XML file.  
Xstream is impressive in its capabilities to serialize and deserialize objects. 
 Only the xstream-1.3.1.jar and objenesis-1.2.jar are required to use this 
recorder.


## Behavior Recorder:

com.advancedpwr.record.mock.MockBehaviorRecorder – Records all method calls 
made on an object tree in a factory that constructs mock objects to replicate 
and verify the expected behavior. 

