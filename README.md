# KeyValueStore

This is a project for COEN 317 - Distributed Computing course at SCU.

Implementing a distributed Key Value Store similar to Cassandra. The milestones for the project are:

*   <span style="line-height: 28px;">Using Chord algorithm to implement a distributed hash table.</span>
*   <span style="line-height: 28px;">Achieve 2 level replication</span>
*   <span style="line-height: 28px;">The end application is for users to store the metadata about the songs like album name, artist and file &nbsp;location.&nbsp;</span>
*   <span style="line-height: 28px;">This is stored in our distributed key‐value store and allow another user (node) to search &nbsp;for the same file even when the original uploader is offline. This makes for a high available and a &nbsp;fault‐tolerant key‐value store. &nbsp;</span>

Following are the current restrictions or shortcomings of the project:

*    <span style="line-height: 28px;"> The program provides concurrent reads and concurrent writes, however simulataneous reads and writes are not possible at the moment. &nbsp;</span>
*    <span style="line-height: 28px;"> Simultaneous node failures are not handled at the moment. That is, since the read repair happens as the node fails and is initiated by the failed node's predecessor, thus if there is simulataneous failures, the system will crash.  &nbsp;</span>
*    <span style="line-height: 28px;"> Currently we have a master program which gives a new port to the incoming new node and makes sure that it doesn't repeat a previously used port. Hence the restriction here is if the master fails, the new node will not be able to join. To overcome this, we can make sure that each node just knows the port of every other node. As a result, if a new incoming node contacts any of the existing node, it can get an appropriate port to get connected into the system &nbsp;</span>
