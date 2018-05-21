package bankersproject;

public class DisplayContent {
	public String IntroContent = "<html>\r\n" + 
			"<head>\r\n" + 
			"<Title>Deadlock Introduction</Title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<h1 align=\"center\">Deadlock </h1>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"There are many resources that can be allocated to only one process at a time, and we have seen several operating system\r\n" + 
			"features that allow this, such as mutexes, semaphores or file locks.\r\n" + 
			"\r\n" + 
			"Sometimes a process has to reserve more than one resource. For example, a process which copies files from one tape to another \r\n" + 
			"generally requires two tape drives. A process which deals with databases may need to lock multiple records in a database. This may \r\n" + 
			"cause other processes to wait for the occupied resource. Because all the processes are waiting, none of them will ever cause any of\r\n" + 
			" the events that could wake up any of the other members of the set, and all the processes continue to wait forever.\r\n" + 
			"\r\n" + 
			"In general, resources allocated to a process are not preemptable; this means that once a resource has been allocated to a process,\r\n" + 
			" there is no simple mechanism by which the system can take the resource back from the process unless the process voluntarily gives \r\n" + 
			"it up or the system administrator kills the process.  This can lead to a situation called deadlock. \r\n" + 
			"\r\n" + 
			"<b>Formal Definition:</b> A set of processes or threads is deadlocked when each process or thread is waiting for a resource to be\r\n" + 
			" freed which is controlled by another process.\r\n" + 
			" \r\n" + 
			" </font>\r\n" + 
			" </pre>\r\n" + 
			" </p>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
	public String Conditions = "<html>\r\n" + 
			"<head>\r\n" + 
			"<Title>Deadlock Conditions</Title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<h1 align=\"center\">Conditions for Deadlock</h1>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"There are four conditions that are necessary to achieve deadlock:\r\n" + 
			"	1.<b>Mutual Exclusion</b> - \r\n" + 
			"	At least one resource must be held in a non-sharable mode; If any other process requests this resource, then that process\r\n" + 
			"	must wait for the resource to be released.\r\n" + 
			"	\r\n" + 
			"	2.<b>Hold and Wait</b> - \r\n" + 
			"	A process must be simultaneously holding at least one resource and waiting for at least one resource that is currently\r\n" + 
			"	being held by some other process.\r\n" + 
			"	\r\n" + 
			"	3.<b>No pre-emption</b> - \r\n" + 
			"	Once a process is holding a resource (i.e. once its request has been granted), then that resource cannot be taken away\r\n" + 
			"	from that process until the process voluntarily releases it.\r\n" + 
			"	\r\n" + 
			"	4.<b>Circular Wait</b> - \r\n" + 
			"	A set of processes {P0, P1, P2, . . ., PN} must exist such that every P[ i ] is waiting for P[ ( i + 1 ) % ( N + 1 ) ].\r\n" + 
			"	(Note that this condition implies the hold-and-wait condition, but it is easier to deal with the conditions if the four\r\n" + 
			"	are considered separately)\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p>\r\n" + 
			"<h2 align=\"center\">Resource Allocation Graphs</h2>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"A resource allocation graph tracks which resource is held by which process and which process is waiting for a resource \r\n" + 
			"of a particular type. It is very powerful and simple tool to illustrate how interacting processes can deadlock.If a process \r\n" + 
			"is using a resource, an arrow is drawn from the resource node to the process node. If a process is requesting a resource, an arrow \r\n" + 
			"is drawn from the process node to the resource node. If there is a cycle in the Resource Allocation Graph and each resource in the \r\n" + 
			"cycle provides only one instance, then the processes will deadlock.\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p> \r\n" + 
			"<h2 align=\"center\">Handling Deadlock</h2>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"<b>Three Methods for handling deadlock:</b> \r\n" + 
			"	1.<b>Deadlock prevention or avoidance:</b> The idea is to not let the system into deadlock state.\r\n" + 
			"	2.<b>Deadlock detection and recovery:</b> Let deadlock occur, then do pre-emption to handle it once occurred.\r\n" + 
			"	3.<b>Ignore the problem all together:</b> If deadlock is very rare, then let it happen and reboot the system.\r\n" + 
			"		This is the approach that both Windows and UNIX take.\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
	public String Banker = "<html>\r\n" + 
			"<body>\r\n" + 
			"<h1 align=\"center\">Banker's Algorithm</h1>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"Banker's algorithm is a deadlock avoidance and prevention algorithm. It is named so because this algorithm is used \r\n" + 
			"in banking systems to determine whether a loan can be granted or not.\r\n" + 
			"\r\n" + 
			"Banker's algorithm works in a similar way in computers. Whenever a new process is created, it must exactly specify \r\n" + 
			"the maximum instances of each resource type that it needs.\r\n" + 
			"\r\n" + 
			"Let us assume that there are n processes and m resource types. \r\n" + 
			"\r\n" + 
			"Some data structures are used to implement the banker's algorithm. They are:\r\n" + 
			"\r\n" + 
			"	1.<b>Available:</b> It is an array of length m. It represents the number of available resources of each type.\r\n" + 
			"		If Available[j] = k, then there are k instances available, of resource type Rj.\r\n" + 
			"	\r\n" + 
			"	2.<b>Max:</b> It is an n x m matrix which represents the maximum number of instances of each resource that a \r\n" + 
			"		process can request. If Max[i][j] = k, then the process Pi can request atmost k instances of resource type Rj.\r\n" + 
			"	\r\n" + 
			"	3.<b>Allocation:</b> It is an n x m matrix which represents the number of resources of each type currently\r\n" + 
			"		allocated to each process. If Allocation[i][j] = k, then process Pi is currently allocated k instances of \r\n" + 
			"		resource type Rj.\r\n" + 
			"		\r\n" + 
			"	4.<b>Need:</b> It is an n x m matrix which indicates the remaining resource needs of each process.\r\n" + 
			"		If Need[i][j] = k, then process Pi may need k more instances of resource type Rj to complete its task.\r\n" + 
			"		<b>Need[i][j] = Max[i][j] - Allocation [i][j]</b>\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
	public String Safety = "<html>\r\n" + 
			"<body>\r\n" + 
			"<h1 align=\"center\">Safety Algorithm</h1>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"\r\n" + 
			"1. Create vector completed[m] to indicate completion of each process. Initially, Completed is all 0.\r\n" + 
			"	Also create vector lAvail with copy of Available.\r\n" + 
			"	This means, initially, no process has finished and the number of available resources is represented\r\n" + 
			"	by the lAvail array.\r\n" + 
			"	\r\n" + 
			"2. Find a process such that,\r\n" + 
			"	completed[i] == 0,\r\n" + 
			"	Need[i] less than lAvail.\r\n" + 
			"	If there is no such i present, then proceed to step 4.\r\n" + 
			"	This step is to find an unfinished process whose need can be satisfied by the available resources.\r\n" + 
			"	If no such process exists, just go to step 4.\r\n" + 
			"	\r\n" + 
			"3. When need can be satisfied, the resources are allocated and the process is marked finished.\r\n" + 
			"	lAvail = lAvail + Alloc[i],\r\n" + 
			"	Completed[i] = true or 1.\r\n" + 
			"	Repeat step 2.\r\n" + 
			"	\r\n" + 
			"4. When an unfinished process is found, then the loop is repeated to check the same for all other processes.\r\n" + 
			"\r\n" + 
			"5. If Finish[i] == true for all processes, then the system is in a safe state.\r\n" + 
			"	That means if all processes are finished, then the system is in safe state.\r\n" + 
			"	If not then system is said to be in Unsafe State. Meanind some process are causing Deadlock.\r\n" + 
			"\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
	public String Request = "<html>\r\n" + 
			"<body>\r\n" + 
			"<h1 align=\"center\">Resource Request Algorithm</h1>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"This describes the behavior of the system when a process makes a resource request in the form of a request matrix.\r\n" + 
			"The steps are:\r\n" + 
			"\r\n" + 
			"1. If Request[i] is less than Need[i], go to step 2.\r\n" + 
			"\r\n" + 
			"2. If Request[i] is less than Aavailable, go to step 3.\r\n" + 
			"	If not, the process has to wait because sufficient resources are not available yet.\r\n" + 
			"	\r\n" + 
			"3. Assuming resources have been allocated. Accordingly do,\r\n" + 
			"	Available = Available – Request[i]\r\n" + 
			"	Allocation[i] = Allocation[i] + Request[i]\r\n" + 
			"	Need[i] = Need[i] – Request[i]\r\n" + 
			"	This step is done because the system needs to assume that resources have been allocated.\r\n" + 
			"	So, there will be less resources available after allocation. The number of allocated instances will increase.\r\n" + 
			"	The need of the resources by the process will reduce. That's what is represented by the above three operations.\r\n" + 
			"\r\n" + 
			"After completing the above three steps, check if the system is in safe state by applying the safety algorithm.\r\n" + 
			" If it is in safe state, proceed to allocate the requested resources. Else, the process has to wait longer.\r\n" + 
			" \r\n" + 
			" This will help Prevent Deadlocks.\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
	public String Recovery = "<html>\r\n" + 
			"<body>\r\n" + 
			"<h1 align=\"center\">Deadlock Recovery</h1>\r\n" + 
			"<p>\r\n" + 
			"<pre>\r\n" + 
			"<font face=\"Times New Roman\" size=3>\r\n" + 
			"Traditional operating system such as Windows doesn’t deal with deadlock recovery as it is time and space consuming process.\r\n" + 
			"Real time operating systems use Deadlock recovery.\r\n" + 
			"\r\n" + 
			"Prominent Methods used for Deadlock Recovery:\r\n" + 
			"\r\n" + 
			"1.<b>Killing the process</b> - \r\n" + 
			"		Killing all the process involved in deadlock. Killing process one by one. After killing each process check for \r\n" + 
			"		deadlock again keep repeating process till system recover from deadlock.\r\n" + 
			"		\r\n" + 
			"2. <b>Resource Preemption</b> -\r\n" + 
			"		Resources are preempted from the processes involved in deadlock, preempted resources are allocated to other processes,\r\n" + 
			"		so that there is a possibility of recovering the system from deadlock. In this case system go into starvation.\r\n" + 
			"		\r\n" + 
			"3. <b>Ostrich Algorithm</b> -\r\n" + 
			"		The ostrich algorithm is a strategy of ignoring potential problems on the basis that they may be exceedingly rare.\r\n" + 
			"		It is named for the ostrich effect which is defined as \"to stick one's head in the sand and pretend there is no problem”.\r\n" + 
			"		It is mainly used when allowing the problems to happen is more cost effective than its prevention.\r\n" + 
			"		For example, if each PC deadlocks once per 10 years, the one reboot may be less painful than the restrictions\r\n" + 
			"		needed to prevent it.\r\n" + 
			"</font>\r\n" + 
			"</pre>\r\n" + 
			"</p>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
}
