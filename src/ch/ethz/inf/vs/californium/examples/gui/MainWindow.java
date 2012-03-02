/*******************************************************************************
 * Copyright (c) 2012, Institute for Pervasive Computing, ETH Zurich.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the Institute nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE INSTITUTE AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE INSTITUTE OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * 
 * This file is part of the Californium CoAP framework.
 ******************************************************************************/
/*
 * Copyright (c) 2011, Institute for Pervasive Computing, ETH Zurich.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the Institute nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE INSTITUTE AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE INSTITUTE OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * This file is part of the Californium CoAP framework.
 */

/*
 * MainWindow.java
 *
 * Created on May 16, 2011, 12:55:25 PM
 */
package ch.ethz.inf.vs.californium.examples.gui;

import ch.ethz.inf.vs.californium.coap.CodeRegistry;
import ch.ethz.inf.vs.californium.coap.DELETERequest;
import ch.ethz.inf.vs.californium.coap.GETRequest;
import ch.ethz.inf.vs.californium.coap.POSTRequest;
import ch.ethz.inf.vs.californium.coap.PUTRequest;
import ch.ethz.inf.vs.californium.coap.Request;
import ch.ethz.inf.vs.californium.coap.Response;
import ch.ethz.inf.vs.californium.endpoint.RemoteResource;
import ch.ethz.inf.vs.californium.endpoint.Resource;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * 
 * @author dominique
 */
public class MainWindow extends javax.swing.JFrame implements ActionListener,
		TreeSelectionListener {

	private static final long serialVersionUID = 7726124034891033644L;
	private static final String stringEncoding = "UTF-8";

	/** Creates new form MainWindow */
	public MainWindow() {
		responseHistory = new ArrayList<responseHistoryEntry>();
		initComponents();
		initButtons();
		initTree();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		controlPanel = new javax.swing.JPanel();
		getButton = new javax.swing.JButton();
		postButton = new javax.swing.JButton();
		putButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		dataEntryField = new javax.swing.JTextField();
		payloadLabel = new javax.swing.JLabel();
		treePanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		resourceTree = new javax.swing.JTree();
		contentPanel = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		contentField = new javax.swing.JTextArea();
		addressPanel = new javax.swing.JPanel();
		uriLabel = new javax.swing.JLabel();
		uriField = new javax.swing.JTextField();
		discoverButton = new javax.swing.JButton();
		statusPanel = new javax.swing.JPanel();
		responseCodePanel = new javax.swing.JLabel();
		responseCodeField = new javax.swing.JTextField();
		jScrollPane3 = new javax.swing.JScrollPane();
		responseHistoryList = new javax.swing.JList();
		responseHistoryLabel = new javax.swing.JLabel();
		rttLabel = new javax.swing.JLabel();
		rttField = new javax.swing.JTextField();
		rttMsLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		controlPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Control"));

		getButton.setBackground(new java.awt.Color(24, 207, 24));
		getButton.setText("GET");
		getButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		postButton.setBackground(new java.awt.Color(240, 237, 37));
		postButton.setForeground(java.awt.Color.black);
		postButton.setText("POST");
		postButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		putButton.setBackground(new java.awt.Color(240, 237, 37));
		putButton.setForeground(java.awt.Color.black);
		putButton.setText("PUT");
		putButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		deleteButton.setBackground(new java.awt.Color(220, 20, 69));
		deleteButton.setForeground(java.awt.Color.white);
		deleteButton.setText("DELETE");
		deleteButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		payloadLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		payloadLabel.setText("Payload");

		javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(
				controlPanel);
		controlPanel.setLayout(controlPanelLayout);
		controlPanelLayout
				.setHorizontalGroup(controlPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								controlPanelLayout
										.createSequentialGroup()
										.addGroup(
												controlPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																controlPanelLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				payloadLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				dataEntryField,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				373,
																				Short.MAX_VALUE))
														.addGroup(
																controlPanelLayout
																		.createSequentialGroup()
																		.addGap(83,
																				83,
																				83)
																		.addComponent(
																				getButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				63,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				putButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				77,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				12,
																				Short.MAX_VALUE)
																		.addComponent(
																				postButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				81,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				deleteButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				94,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));

		controlPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { getButton, postButton, putButton });

		controlPanelLayout
				.setVerticalGroup(controlPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								controlPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												controlPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																payloadLabel)
														.addComponent(
																dataEntryField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(4, 4, 4)
										.addGroup(
												controlPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																getButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																putButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																deleteButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																postButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		treePanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Resources"));

		resourceTree.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				resourceTreeMouseClicked(evt);
			}
		});
		resourceTree
				.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
					public void valueChanged(
							javax.swing.event.TreeSelectionEvent evt) {
						resourceTreeValueChanged(evt);
					}
				});
		resourceTree
				.addContainerListener(new java.awt.event.ContainerAdapter() {
					public void componentAdded(java.awt.event.ContainerEvent evt) {
						resourceTreeComponentAdded(evt);
					}
				});
		resourceTree
				.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
					public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
						resourceTreeAncestorMoved(evt);
					}

					public void ancestorResized(
							java.awt.event.HierarchyEvent evt) {
					}
				});
		jScrollPane1.setViewportView(resourceTree);
		resourceTree.getAccessibleContext().setAccessibleName("resourceTree");

		javax.swing.GroupLayout treePanelLayout = new javax.swing.GroupLayout(
				treePanel);
		treePanel.setLayout(treePanelLayout);
		treePanelLayout.setHorizontalGroup(treePanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				treePanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 230,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		treePanelLayout.setVerticalGroup(treePanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				treePanelLayout
						.createSequentialGroup()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 363,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		contentPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Data"));

		contentField.setColumns(20);
		contentField.setLineWrap(true);
		contentField.setRows(5);
		contentField.setText("payload");
		jScrollPane2.setViewportView(contentField);

		javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(
				contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout
				.setHorizontalGroup(contentPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								contentPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												728, Short.MAX_VALUE)
										.addContainerGap()));
		contentPanelLayout
				.setVerticalGroup(contentPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								contentPanelLayout
										.createSequentialGroup()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												315, Short.MAX_VALUE)
										.addContainerGap()));

		addressPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Address"));

		uriLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		uriLabel.setText("URI");

		uriField.setText("coap://vs0.inf.ethz.ch:61616/.well-known/core");

		discoverButton.setBackground(new java.awt.Color(165, 178, 226));
		discoverButton.setText("DISCOVER");
		discoverButton.setActionCommand("discover");
		discoverButton.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		javax.swing.GroupLayout addressPanelLayout = new javax.swing.GroupLayout(
				addressPanel);
		addressPanel.setLayout(addressPanelLayout);
		addressPanelLayout
				.setHorizontalGroup(addressPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								addressPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(uriLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												uriField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												592,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												discoverButton,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												94, Short.MAX_VALUE)
										.addContainerGap()));
		addressPanelLayout
				.setVerticalGroup(addressPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								addressPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												addressPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																uriField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(uriLabel)
														.addComponent(
																discoverButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																26,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		statusPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Status"));

		responseCodePanel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		responseCodePanel.setText("responseCode");

		jScrollPane3.setViewportView(responseHistoryList);

		responseHistoryLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		responseHistoryLabel.setText("responseHistory");

		rttLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		rttLabel.setText("RTT");

		rttField.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		rttField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		rttField.setText("-");

		rttMsLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		rttMsLabel.setText("ms");

		javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(
				statusPanel);
		statusPanel.setLayout(statusPanelLayout);
		statusPanelLayout
				.setHorizontalGroup(statusPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								statusPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												statusPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																statusPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				responseHistoryLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																statusPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				statusPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								rttLabel)
																						.addComponent(
																								responseCodePanel))
																		.addGap(26,
																				26,
																				26)))
										.addGap(12, 12, 12)
										.addGroup(
												statusPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																300,
																Short.MAX_VALUE)
														.addGroup(
																statusPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				rttField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				61,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				rttMsLabel))
														.addComponent(
																responseCodeField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																155,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		statusPanelLayout
				.setVerticalGroup(statusPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								statusPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												statusPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																responseCodePanel)
														.addComponent(
																responseCodeField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												statusPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																rttField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(rttLabel)
														.addComponent(
																rttMsLabel))
										.addGap(47, 47, 47)
										.addGroup(
												statusPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																responseHistoryLabel)
														.addComponent(
																jScrollPane3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																86,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(33, 33, 33)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														addressPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		treePanel,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						statusPanel,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						controlPanel,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)))
												.addComponent(
														contentPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(addressPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		controlPanel,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		statusPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		279,
																		Short.MAX_VALUE))
												.addComponent(
														treePanel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(contentPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(66, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void resourceTreeMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_resourceTreeMouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_resourceTreeMouseClicked

	private void resourceTreeValueChanged(
			javax.swing.event.TreeSelectionEvent evt) {// GEN-FIRST:event_resourceTreeValueChanged
		// TODO add your handling code here:
		StringBuilder uri = new StringBuilder();
		uri.append("coap://");
		StringTokenizer st = new StringTokenizer(evt.getNewLeadSelectionPath()
				.toString(), "[ ,]");
		while (st.hasMoreTokens()) {
			uri.append(st.nextToken());
			uri.append("/");
		}
		uri.deleteCharAt(uri.length() - 1);
		uriField.setText(uri.toString());
	}// GEN-LAST:event_resourceTreeValueChanged

	private void resourceTreeComponentAdded(java.awt.event.ContainerEvent evt) {// GEN-FIRST:event_resourceTreeComponentAdded
		// TODO add your handling code here:
		// System.err.println("Component Added");
	}// GEN-LAST:event_resourceTreeComponentAdded

	private void resourceTreeAncestorMoved(java.awt.event.HierarchyEvent evt) {// GEN-FIRST:event_resourceTreeAncestorMoved
		// TODO add your handling code here:
		resourceTree.updateUI();
		this.repaint();
	}// GEN-LAST:event_resourceTreeAncestorMoved

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel addressPanel;
	private javax.swing.JTextArea contentField;
	private javax.swing.JPanel contentPanel;
	private javax.swing.JPanel controlPanel;
	private javax.swing.JTextField dataEntryField;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton discoverButton;
	private javax.swing.JButton getButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JLabel payloadLabel;
	private javax.swing.JButton postButton;
	private javax.swing.JButton putButton;
	private javax.swing.JTree resourceTree;
	private javax.swing.JTextField responseCodeField;
	private javax.swing.JLabel responseCodePanel;
	private javax.swing.JLabel responseHistoryLabel;
	private javax.swing.JList responseHistoryList;
	private javax.swing.JTextField rttField;
	private javax.swing.JLabel rttLabel;
	private javax.swing.JLabel rttMsLabel;
	private javax.swing.JPanel statusPanel;
	private javax.swing.JPanel treePanel;
	private javax.swing.JTextField uriField;
	private javax.swing.JLabel uriLabel;
	// End of variables declaration//GEN-END:variables
	private DefaultMutableTreeNode rootNode;
	private List<responseHistoryEntry> responseHistory;
	
	

	private void initButtons() {
		getButton.addActionListener(this);
		postButton.addActionListener(this);
		putButton.addActionListener(this);
		deleteButton.addActionListener(this);
		discoverButton.addActionListener(this);
	}

	private void initTree() {
		rootNode = ((DefaultMutableTreeNode) (resourceTree.getModel().getRoot()));
		rootNode.removeAllChildren();
		rootNode.setUserObject(new String("Resource"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("get")) {
			handleGet(e);
		} else if (e.getActionCommand().equalsIgnoreCase("discover")) {
			handleResourceDiscovery(e);
		} else if (e.getActionCommand().equalsIgnoreCase("post")) {
			handlePost(e);
		} else if (e.getActionCommand().equalsIgnoreCase("put")) {
			handlePut(e);
		} else if (e.getActionCommand().equalsIgnoreCase("delete")) {
			handleDelete(e);
		} else {
			System.err.println("unknown command");
		}
	}

	public void handleGet(ActionEvent e) {
		String[] uriTokens = uriField.getText().split("/");
		int length = uriTokens.length;
		if (uriTokens[length - 2].equalsIgnoreCase(".well-known")
				&& uriTokens[length - 1].equalsIgnoreCase("core")) {
			// System.err.println("Resource Discovery");
			handleResourceDiscovery(e);
		} else {
			Request request = new GETRequest() {

				@Override
				protected void handleResponse(Response response) {
					contentField.setText(response.getPayloadString());
					populateStatusFields(response);
					responseHistory.add(new responseHistoryEntry(CodeRegistry
							.toString(response.getRequest().getCode()),
							getCurrentTime(), CodeRegistry.toString(response
									.getCode()), response.getRTT()));

				}
			};
			request.setURI(uriField.getText());
			try {
				request.execute();
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}

	}

	public void handleResourceDiscovery(ActionEvent e) {
		Request request = new GETRequest() {

			@Override
			protected void handleResponse(Response response) {
				Resource root;
				try {
					root = RemoteResource.newRoot(new String(response
							.getPayload(), stringEncoding));
					populateTree(root, rootNode);
					resourceTree.expandPath(new TreePath(rootNode.getPath()));
					updateTree();
					contentField.setText("Resource Discovery");
					populateStatusFields(response);
				} catch (UnsupportedEncodingException ex) {
					Logger.getLogger(MainWindow.class.getName()).log(
							Level.SEVERE, null, ex);
				}

			}
		};
		request.setURI(uriField.getText());
		String uri = uriField.getText();
		// System.err.println(getHost(uri));
		rootNode.removeAllChildren();
		rootNode.setUserObject(getHost(uri));
		try {
			request.execute();
			// expandAll();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void handlePost(ActionEvent e) {
		Request request = new POSTRequest() {

			@Override
			protected void handleResponse(Response response) {
				contentField.setText(response.getPayloadString());
				populateStatusFields(response);
			}
		};
		request.setPayload(dataEntryField.getText());
		request.setURI(uriField.getText());
		try {
			request.execute();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void handlePut(ActionEvent e) {
		Request request = new PUTRequest() {

			@Override
			protected void handleResponse(Response response) {
				contentField.setText(response.getPayloadString());
				populateStatusFields(response);
			}
		};
		request.setPayload(dataEntryField.getText());
		request.setURI(uriField.getText());
		try {
			request.execute();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void handleDelete(ActionEvent e) {
		Request request = new DELETERequest() {

			@Override
			protected void handleResponse(Response response) {
				contentField.setText(response.getPayloadString());
				populateStatusFields(response);
			}
		};
		request.setURI(uriField.getText());
		try {
			request.execute();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void populateTree(Resource currentRoot,
			DefaultMutableTreeNode currentRootNode) {
		Resource[] resources = currentRoot.getSubResources();
		if (resources != null) {
			for (int i = 0; i < resources.length; i++) {
				currentRootNode.add(new DefaultMutableTreeNode(resources[i]
						.getResourceIdentifier()));
				populateTree(resources[i],
						(DefaultMutableTreeNode) currentRootNode.getChildAt(i));
				// System.err.println(resources[i].getResourceIdentifier());
			}
		}
	}

	public void expandAll() {
		DefaultMutableTreeNode node;
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> nodes = rootNode.breadthFirstEnumeration();
		while (nodes.hasMoreElements()) {
			node = (DefaultMutableTreeNode) nodes.nextElement();
			TreePath path = new TreePath(node.getPath());
			resourceTree.expandPath(path);
		}
	}

	public void populateStatusFields(Response response) {
		responseCodeField.setText(CodeRegistry.toString(response.getCode()));
		rttField.setText(Integer.toString(response.getRTT()));
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
	}

	public String getHost(String uri) {
		StringTokenizer st = new StringTokenizer(uri, "/");
		st.nextToken();
		return st.nextToken();
	}

	private class responseHistoryEntry {

		private int RTT;
		private String returnCode;
		private String timestamp;
		private String requestType;

		public responseHistoryEntry(String requestType, String timestamp,
				String returnCode, int rtt) {
			this.requestType = requestType;
			this.timestamp = timestamp;
			this.returnCode = returnCode;
			this.RTT = rtt;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Time: ");
			sb.append(timestamp);
			sb.append("\n");
			sb.append("Return code: ");
			sb.append(returnCode);
			sb.append("\n");
			sb.append("Request type: ");
			sb.append(requestType);
			sb.append("\n");
			sb.append("RTT: ");
			sb.append(RTT);
			sb.append("\n");
			return sb.toString();
		}
	}

	private void updateTree() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				resourceTree.updateUI();
			}
		});
	}

	private String getCurrentTime() {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return format.format(date);
	}
}
