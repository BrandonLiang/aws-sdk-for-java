/*
 * Copyright 2010 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpledb;
            
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;

import com.amazonaws.services.simpledb.model.*;


/**
 * Client for accessing AmazonSimpleDB.  All calls made
 * using this client are non-blocking and will immediately return a Java Future.
 * Callers must use the Future object to determine when the service call has actually
 * completed.
 * <p>
 * Amazon SimpleDB is a web service providing the core database
 * functions of data indexing and querying in the cloud. By offloading
 * the time and effort associated with building and operating a web-scale
 * database, SimpleDB provides developers the freedom to focus on
 * application development.
 * </p>
 * <p>
 * A traditional, clustered relational database requires a sizable
 * upfront capital outlay, is complex to design, and often requires
 * extensive and repetitive database administration. Amazon SimpleDB is
 * dramatically simpler, requiring no schema, automatically indexing your
 * data and providing a simple API for storage and access. This approach
 * eliminates the administrative burden of data modeling, index
 * maintenance, and performance tuning. Developers gain access to this
 * functionality within Amazon's proven computing environment, are able
 * to scale instantly, and pay only for what they use.
 * </p>
 * <p>
 * Visit <a href="http://aws.amazon.com/simpledb/">
 * http://aws.amazon.com/simpledb/ </a> for more information.
 * </p> 
 */       
public class AmazonSimpleDBAsyncClient extends AmazonSimpleDBClient
        implements AmazonSimpleDBAsync { 

    /**
     * Executor service for executing asynchronous requests.
     */
    private ExecutorService executorService;

    
    /**
     * Constructs a new asynchronous client to invoke service methods on 
     * AmazonSimpleDB using the specified AWS account credentials.
     * Default client settings will be used, and a default cached thread pool will be 
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     * 
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */                                      
    public AmazonSimpleDBAsyncClient(AWSCredentials awsCredentials) {
        this(awsCredentials, Executors.newCachedThreadPool());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonSimpleDB using the specified AWS account credentials
     * and executor service.  Default client settings will be used.
     * 
     * <p> 
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     * 
     * @param awsCredentials 
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonSimpleDBAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
        super(awsCredentials);
        this.executorService = executorService;
    }
     
    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonSimpleDB using the specified AWS account credentials,
     * executor service, and client configuration options.
     * 
     * <p> 
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     * 
     * @param awsCredentials 
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonSimpleDBAsyncClient(AWSCredentials awsCredentials,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }
     
    /**
     * Returns the executor service used by this async client to execute
     * requests.
     *   
     * @return The executor service used by this async client to execute
     *         requests.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }
            
    /**
     * <p>
     * The Select operation returns a set of Attributes for ItemNames that
     * match the select expression. Select is similar to the standard SQL
     * SELECT statement.
     * </p>
     * <p>
     * The total size of the response cannot exceed 1 MB in total size.
     * Amazon SimpleDB automatically adjusts the number of items returned per
     * page to enforce this limit. For example, even if you ask to retrieve
     * 2500 items, but each individual item is 10 kB in size, the system
     * returns 100 items and an appropriate next token so you can get the
     * next page of results.
     * </p>
     * <p>
     * For information on how to construct select expressions, see Using
     * Select to Create Amazon SimpleDB Queries in the Developer Guide.
     * </p>
     *
     * @param selectRequest Container for the necessary parameters to execute
     *           the Select operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the Select
     *         service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SelectResult> selectAsync(final SelectRequest selectRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SelectResult>() {
            public SelectResult call() throws Exception {
                return select(selectRequest);
		    }
		});
    }
    
    /**
     * <p>
     * The PutAttributes operation creates or replaces attributes in an
     * item. You specify new attributes using a combination of the
     * <code>Attribute.X.Name</code> and <code>Attribute.X.Value</code>
     * parameters. You specify the first attribute by the parameters
     * <code>Attribute.0.Name</code> and <code>Attribute.0.Value</code> ,
     * the second attribute by the parameters <code>Attribute.1.Name</code>
     * and <code>Attribute.1.Value</code> , and so on.
     * </p>
     * <p>
     * Attributes are uniquely identified in an item by their name/value
     * combination. For example, a single item can have the attributes
     * <code>{ "first_name", "first_value" }</code> and <code>{ "first_name",
     * second_value" }</code> . However, it cannot have two attribute
     * instances where both the <code>Attribute.X.Name</code> and
     * <code>Attribute.X.Value</code> are the same.
     * </p>
     * <p>
     * Optionally, the requestor can supply the Replace parameter for each
     * individual attribute. Setting this value to true causes the new
     * attribute value to replace the existing attribute value(s). For
     * example, if an item has the attributes <code>{ 'a', '1' }</code> ,
     * 
     * <code>{ 'b', '2'}</code> and <code>{ 'b', '3'
     * }</code> and the requestor calls PutAttributes using the attributes
     * <code>{ 'b', '4' }</code> with the Replace parameter set to true, the
     * final attributes of the item are changed to <code>{ 'a', '1' }</code>
     * and <code>{ 'b', '4' }</code> , which replaces the previous values of
     * the 'b' attribute with the new value.
     * </p>
     * <p>
     * <b>NOTE:</b> Using PutAttributes to replace attribute values that do
     * not exist will not result in an error response.
     * </p>
     * <p>
     * You cannot specify an empty string as an attribute name.
     * </p>
     * <p>
     * Because Amazon SimpleDB makes multiple copies of your data and uses
     * an eventual consistency update model, an immediate GetAttributes or
     * Select request (read) immediately after a DeleteAttributes request
     * (write) might not return the updated data.
     * </p>
     * <p>
     * The following limitations are enforced for this operation:
     * <ul>
     * <li>256 total attribute name-value pairs per item</li>
     * <li>One billion attributes per domain</li>
     * <li>10 GB of total user data storage per domain</li>
     * 
     * </ul>
     * 
     * </p>
     *
     * @param putAttributesRequest Container for the necessary parameters to
     *           execute the PutAttributes operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         PutAttributes service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putAttributesAsync(final PutAttributesRequest putAttributesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                putAttributes(putAttributesRequest);
                return null;
		    }
		});
    }
    
    /**
     * <p>
     * The DeleteDomain operation deletes a domain. Any items (and their
     * attributes) in the domain are deleted as well. The DeleteDomain
     * operation might take 10 or more seconds to complete.
     * </p>
     * <p>
     * <b>NOTE:</b> Running DeleteDomain on a domain that does not exist or
     * running the function multiple times using the same domain name will
     * not result in an error response.
     * </p>
     *
     * @param deleteDomainRequest Container for the necessary parameters to
     *           execute the DeleteDomain operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteDomain service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteDomainAsync(final DeleteDomainRequest deleteDomainRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteDomain(deleteDomainRequest);
                return null;
		    }
		});
    }
    
    /**
     * <p>
     * The CreateDomain operation creates a new domain. The domain name must
     * be unique among the domains associated with the Access Key ID provided
     * in the request. The CreateDomain operation may take 10 or more seconds
     * to complete.
     * </p>
     * <p>
     * <b>NOTE:</b> CreateDomain is an idempotent operation; running it
     * multiple times using the same domain name will not result in an error
     * response.
     * </p>
     * <p>
     * You can create up to 100 domains per account.
     * </p>
     * <p>
     * If you require additional domains, go to <a
     * href="http://aws.amazon.com/contact-us/simpledb-limit-request/">
     * http://aws.amazon.com/contact-us/simpledb-limit-request/ </a> .
     * </p>
     *
     * @param createDomainRequest Container for the necessary parameters to
     *           execute the CreateDomain operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         CreateDomain service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createDomainAsync(final CreateDomainRequest createDomainRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                createDomain(createDomainRequest);
                return null;
		    }
		});
    }
    
    /**
     * <p>
     * Deletes one or more attributes associated with the item. If all
     * attributes of an item are deleted, the item is deleted.
     * </p>
     * <p>
     * <b>NOTE:</b> If you specify DeleteAttributes without attributes or
     * values, all the attributes for the item are deleted.
     * </p>
     * <p>
     * DeleteAttributes is an idempotent operation; running it multiple
     * times on the same item or attribute does not result in an error
     * response.
     * </p>
     * <p>
     * Because Amazon SimpleDB makes multiple copies of your data and uses
     * an eventual consistency update model, performing a GetAttributes or
     * Select request (read) immediately after a DeleteAttributes or
     * PutAttributes request (write) might not return the updated data.
     * </p>
     *
     * @param deleteAttributesRequest Container for the necessary parameters
     *           to execute the DeleteAttributes operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAttributes service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAttributesAsync(final DeleteAttributesRequest deleteAttributesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteAttributes(deleteAttributesRequest);
                return null;
		    }
		});
    }
    
    /**
     * <p>
     * The ListDomains operation lists all domains associated with the
     * Access Key ID. It returns domain names up to the limit set by
     * MaxNumberOfDomains. A NextToken is returned if there are more than
     * MaxNumberOfDomains domains. Calling ListDomains successive times with
     * the NextToken returns up to MaxNumberOfDomains more domain names each
     * time.
     * </p>
     *
     * @param listDomainsRequest Container for the necessary parameters to
     *           execute the ListDomains operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         ListDomains service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ListDomainsResult> listDomainsAsync(final ListDomainsRequest listDomainsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListDomainsResult>() {
            public ListDomainsResult call() throws Exception {
                return listDomains(listDomainsRequest);
		    }
		});
    }
    
    /**
     * <p>
     * Returns all of the attributes associated with the item. Optionally,
     * the attributes returned can be limited to one or more specified
     * attribute name parameters.
     * </p>
     * <p>
     * If the item does not exist on the replica that was accessed for this
     * operation, an empty set is returned. The system does not return an
     * error as it cannot guarantee the item does not exist on other
     * replicas.
     * </p>
     * <p>
     * <b>NOTE:</b> If you specify GetAttributes without any attribute names,
     * all the attributes for the item are returned.
     * </p>
     *
     * @param getAttributesRequest Container for the necessary parameters to
     *           execute the GetAttributes operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         GetAttributes service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<GetAttributesResult> getAttributesAsync(final GetAttributesRequest getAttributesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetAttributesResult>() {
            public GetAttributesResult call() throws Exception {
                return getAttributes(getAttributesRequest);
		    }
		});
    }
    
    /**
     * <p>
     * The BatchPutAttributes operation creates or replaces attributes
     * within one or more items.
     * </p>
     * <p>
     * You specify the item name with the <code>Item.X.ItemName</code>
     * parameter. You specify new attributes using a combination of the
     * <code>Item.X.Attribute.Y.Name</code> and
     * <code>Item.X.Attribute.Y.Value</code> parameters. You specify the
     * first attribute for the first item by the parameters
     * <code>Item.0.Attribute.0.Name</code> and
     * <code>Item.0.Attribute.0.Value</code> ,
     * the second attribute for the first item by the parameters
     * <code>Item.0.Attribute.1.Name</code> and
     * <code>Item.0.Attribute.1.Value</code> ,
     * and so on.
     * </p>
     * <p>
     * Attributes are uniquely identified within an item by their name/value
     * combination. For example, a single item can have the attributes
     * <code>{ "first_name", "first_value" }</code> and <code>{ "first_name",
     * "second_value" }</code> .
     * However, it cannot have two attribute instances where both the
     * <code>Item.X.Attribute.Y.Name</code> and
     * <code>Item.X.Attribute.Y.Value</code> are the same.
     * </p>
     * <p>
     * Optionally, the requester can supply the Replace parameter for each
     * individual value. Setting this value to true will cause the new
     * attribute value to replace the existing attribute value(s). For
     * example, if an item <code>I</code> has the attributes <code>{ 'a', '1'
     * }, { 'b', '2'}</code> and <code>{ 'b', '3' }</code> and the requester
     * does a BatchPutAttributes of <code>{'I', 'b', '4' }</code> with the
     * Replace parameter set to true, the final attributes of the item will
     * be <code>{ 'a', '1' }</code> and <code>{ 'b', '4' }</code> ,
     * replacing the previous values of the 'b' attribute with the new
     * value.
     * </p>
     * <p>
     * <b>NOTE:</b> You cannot specify an empty string as an item or
     * attribute name. The BatchPutAttributes operation succeeds or fails in
     * its entirety. There are no partial puts.
     * </p>
     * <p>
     * You can execute multiple BatchPutAttributes operations and other
     * operations in parallel. However, large numbers of concurrent
     * BatchPutAttributes calls can result in Service Unavailable (503)
     * responses.
     * </p>
     * <p>
     * The following limitations are enforced for this operation:
     * <ul>
     * <li>256 attribute name-value pairs per item</li>
     * <li>1 MB request size</li>
     * <li>1 billion attributes per domain</li>
     * <li>10 GB of total user data storage per domain</li>
     * <li>25 item limit per BatchPutAttributes operation</li>
     * 
     * </ul>
     * 
     * </p>
     *
     * @param batchPutAttributesRequest Container for the necessary
     *           parameters to execute the BatchPutAttributes operation on
     *           AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         BatchPutAttributes service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> batchPutAttributesAsync(final BatchPutAttributesRequest batchPutAttributesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                batchPutAttributes(batchPutAttributesRequest);
                return null;
		    }
		});
    }
    
    /**
     * <p>
     * Returns information about the domain, including when the domain was
     * created, the number of items and attributes, and the size of attribute
     * names and values.
     * </p>
     *
     * @param domainMetadataRequest Container for the necessary parameters to
     *           execute the DomainMetadata operation on AmazonSimpleDB.
     * 
     * @return A Java Future object containing the response from the
     *         DomainMetadata service method, as returned by AmazonSimpleDB.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonSimpleDB indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DomainMetadataResult> domainMetadataAsync(final DomainMetadataRequest domainMetadataRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DomainMetadataResult>() {
            public DomainMetadataResult call() throws Exception {
                return domainMetadata(domainMetadataRequest);
		    }
		});
    }
    
}
        